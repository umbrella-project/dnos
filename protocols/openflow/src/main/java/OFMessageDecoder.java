import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import org.projectfloodlight.openflow.protocol.OFFactories;
import org.projectfloodlight.openflow.protocol.OFMessage;
import org.projectfloodlight.openflow.protocol.OFMessageReader;

import java.util.List;

/**
 * OpenFlow message decoder.
 */
public class OFMessageDecoder extends ByteToMessageDecoder {


    private OFMessageDecoder() {
    }

    public static OFMessageDecoder getInstance() {

        return new OFMessageDecoder();
    }

    @Override
    protected void decode(ChannelHandlerContext ctx,
                          ByteBuf byteBuf,
                          List<Object> out) throws Exception {


        if (!ctx.channel().isActive()) {

            return;
        }


        OFMessageReader<OFMessage> reader = OFFactories.getGenericReader();
        OFMessage message = reader.readFrom(byteBuf);


        while (message != null) {
            out.add(message);
            message = reader.readFrom(byteBuf);
        }
    }

}
