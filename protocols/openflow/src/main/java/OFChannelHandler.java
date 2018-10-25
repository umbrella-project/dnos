import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;
import net.floodlightcontroller.core.internal.SwitchStateException;
import org.apache.log4j.Logger;
import org.onlab.packet.IpAddress;
import org.projectfloodlight.openflow.protocol.OFFactories;
import org.projectfloodlight.openflow.protocol.OFFactory;
import org.projectfloodlight.openflow.protocol.OFFeaturesReply;
import org.projectfloodlight.openflow.protocol.OFHello;
import org.projectfloodlight.openflow.protocol.OFHelloElem;
import org.projectfloodlight.openflow.protocol.OFMessage;
import org.projectfloodlight.openflow.protocol.OFMeterFeaturesStatsReply;
import org.projectfloodlight.openflow.protocol.OFPortDescStatsReply;
import org.projectfloodlight.openflow.protocol.OFPortDescStatsRequest;
import org.projectfloodlight.openflow.protocol.OFStatsReply;
import org.projectfloodlight.openflow.protocol.OFVersion;
import org.projectfloodlight.openflow.types.U32;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class OFChannelHandler extends ChannelInboundHandlerAdapter {


    final static Logger log = Logger.getLogger(OFChannelHandler.class);
    protected OFVersion ofVersion;
    protected OFFactory factory;
    private volatile ChannelState channelState;
    private volatile long lastStateChange = System.currentTimeMillis();
    private Channel channel;
    private String channelId;
    private int handshakeTransactionIds = -1;
    private OFFeaturesReply featuresReply;
    private List<OFPortDescStatsReply> portDescReplies;
    private OFMeterFeaturesStatsReply meterFeaturesReply;


    OFChannelHandler() {


        this.channelState = ChannelState.INIT;

    }

    private void setState(ChannelState state) {
        this.channelState = state;
        this.lastStateChange = System.currentTimeMillis();
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {


        channel = ctx.channel();
        log.info("New switch connection from {}" + channel.remoteAddress());

        SocketAddress address = channel.remoteAddress();
        if (address instanceof InetSocketAddress) {
            final InetSocketAddress inetAddress = (InetSocketAddress) address;
            final IpAddress ipAddress = IpAddress.valueOf(inetAddress.getAddress());
            if (ipAddress.isIp4()) {
                channelId = ipAddress.toString() + ':' + inetAddress.getPort();
            } else {
                channelId = '[' + ipAddress.toString() + "]:" + inetAddress.getPort();
            }
        } else {
            channelId = channel.toString();
        }


        setState(ChannelState.HELLO_WAIT);

    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {


        boolean release = true;

        try {
            if (msg instanceof OFMessage) {

                channelState.processOFMessage(this, (OFMessage) msg);


            } else {
                release = false;
                ctx.fireChannelRead(msg);
            }
        } finally {
            if (release) {
                ReferenceCountUtil.release(msg);
            }
        }


    }
    private void sendHandshakeOFPortDescRequest() throws IOException {
        log.debug("Sending OF_PORT_DESC_REQUEST to "+ channel.remoteAddress());
        // Get port description for 1.3+ switch
        OFPortDescStatsRequest preq = factory
                .buildPortDescStatsRequest()
                .setXid(handshakeTransactionIds--)
                .build();
        channel.writeAndFlush(Collections.singletonList(preq));
    }


    private void sendHandshakeHelloMessage() throws IOException {

        U32 bitmap = U32.ofRaw((0b1 << OFVersion.OF_10.getWireVersion()) |
                (0b1 << OFVersion.OF_13.getWireVersion()) |
                (0b1 << OFVersion.OF_14.getWireVersion()) |
                (0b1 << OFVersion.OF_15.getWireVersion()));
        OFVersion version = Optional.ofNullable(ofVersion).orElse(OFVersion.OF_13);
        OFHelloElem hem = OFFactories.getFactory(version)
                .buildHelloElemVersionbitmap()
                .setBitmaps(Collections.singletonList(bitmap))
                .build();
        OFMessage.Builder mb = OFFactories.getFactory(version)
                .buildHello()
                .setXid(this.handshakeTransactionIds--)
                .setElements(Collections.singletonList(hem));

        log.info("Sending Hello to " + version + channel.remoteAddress());
        ChannelFuture cf = channel.writeAndFlush(Collections.singletonList(mb.build()));
        log.info(cf.isSuccess());

    }

    private void sendHandshakeFeaturesRequestMessage() throws IOException {
        log.debug("Sending FEATURES_REQUEST to " + channel.remoteAddress());
        OFMessage m = factory.buildFeaturesRequest()
                .setXid(this.handshakeTransactionIds--)
                .build();
        channel.writeAndFlush(Collections.singletonList(m));
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx,
                                Throwable cause)
            throws Exception {


        log.debug(cause.getLocalizedMessage());
        //do more exception handling
        ctx.close();


    }


    public enum ChannelState {


        INIT {
            @Override
            void processOFMessage(OFChannelHandler h, OFMessage m)
                    throws IOException, SwitchStateException {

                log.debug("INIT STATE\n");

            }


        },
        HELLO_WAIT {
            @Override
            void processOFHello(OFChannelHandler h, OFHello m) throws IOException {


                if (m.getVersion().getWireVersion() >= OFVersion.OF_13.getWireVersion()) {
                    log.debug("Received  Hello from  - switching to OF "
                            + "version 1.3+" + m.getVersion() + h.channel.remoteAddress());
                    h.ofVersion = m.getVersion();
                    h.factory = OFFactories.getFactory(h.ofVersion);
                    h.sendHandshakeHelloMessage();

                } else if (m.getVersion().getWireVersion() >= OFVersion.OF_10.getWireVersion()) {
                    log.debug("Received Hello from  - switching to OF " + "version 1.0" + m.getVersion() + h.channel.remoteAddress());
                    h.ofVersion = m.getVersion();
                    h.factory = OFFactories.getFactory(h.ofVersion);
                    OFHello hi =
                            h.factory.buildHello()
                                    .setXid(h.handshakeTransactionIds--)
                                    .build();
                    h.channel.writeAndFlush(Collections.singletonList(hi));
                } else {
                    log.error("Received Hello of version  from switch at {}. "
                            + "This controller works with OF1.0 and OF1.3 "
                            + "switches. Disconnecting switch ..." + m.getVersion() + h.channel.remoteAddress());
                    h.channel.disconnect();
                    return;
                }
                h.sendHandshakeFeaturesRequestMessage();
                h.setState(FEATURES_REPLY_WAIT);

            }


        },
        FEATURES_REPLY_WAIT {
            @Override
            void processOFFeaturesReply(OFChannelHandler h, OFFeaturesReply m)
                    throws IOException {
                Long dpid = m.getDatapathId().getLong();
                /*if (!h.setDpid(dpid, h.channel)) {
                    log.error("Switch presented invalid certificate for dpid. Disconnecting" + dpid);
                    h.channel.disconnect();
                    return;
                }*/
                //log.debug("Received features reply for switch at {} with dpid {}" + h.getSwitchInfoString(), h.thisdpid);

                h.featuresReply = m; //temp store
                if (h.ofVersion == OFVersion.OF_10) {
                    //h.sendHandshakeSetConfig();
                    //h.setState(WAIT_CONFIG_REPLY);
                } else {
                    //version is 1.3, must get switchport information
                    h.sendHandshakeOFPortDescRequest();
                    h.setState(PORT_DESC_REPLY_WAIT);
                }

                log.info("Process Features Reply\n");

            }




        },

        PORT_DESC_REPLY_WAIT{




        };


        void processOFMessage(OFChannelHandler h, OFMessage m)
                throws IOException, SwitchStateException {

            switch (m.getType()) {
                case HELLO:
                    processOFHello(h, (OFHello) m);
                    break;
                case FEATURES_REPLY:
                    processOFFeaturesReply(h, (OFFeaturesReply) m);
                    break;
            }
        }


        void processOFHello(OFChannelHandler h, OFHello m)
                throws IOException, SwitchStateException {
            // we only expect hello in the WAIT_HELLO state
            log.warn("Received Hello outside WAIT_HELLO state; switch {} is not complaint.");
        }


        void processOFFeaturesReply(OFChannelHandler h, OFFeaturesReply m)  throws IOException{

        }


    }








}
