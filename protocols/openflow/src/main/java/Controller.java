import com.google.common.collect.ImmutableList;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * The main controller class that handles connections to the network switches.
 */

public class Controller {

    final static Logger log = Logger.getLogger(Controller.class);
    protected List<Integer> openFlowPorts = ImmutableList.of(6633, 6653);

    public Controller() {

    }

    public void run() throws Exception {
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();


        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        public void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline pipeline = ch.pipeline();
                            pipeline.addLast("ofmsgencoder",OFMessageEncoder.getInstance());
                            pipeline.addLast("ofmsgdecoder", OFMessageDecoder.getInstance());
                            pipeline.addLast(new OFChannelHandler());

                        }
                    })
                    .option(ChannelOption.SO_REUSEADDR, true)
                    .childOption(ChannelOption.SO_KEEPALIVE, true);

            // Bind and start to accept incoming connections.
            List<ChannelFuture> futures = new ArrayList<>();

            for (Integer port : openFlowPorts) {
                futures.add(b.bind(port).sync());

            }

            for (ChannelFuture f : futures) {
                f.channel().closeFuture().sync();
            }


        } finally {
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }
    }

}
