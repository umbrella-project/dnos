import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.EncoderException;
import org.projectfloodlight.openflow.protocol.OFMessage;
@ChannelHandler.Sharable
public class OFMessageEncoder extends ChannelOutboundHandlerAdapter {


    private static final OFMessageEncoder INSTANCE = new OFMessageEncoder();

    public static OFMessageEncoder getInstance() {
        return INSTANCE;
    }

    private OFMessageEncoder() {}

    protected final void encode(ChannelHandlerContext ctx,
                                Iterable<OFMessage> msgs,
                                ByteBuf out) {

        msgs.forEach(msg -> msg.writeTo(out));
    }


    @Override
    public void write(ChannelHandlerContext ctx,
                      Object msg,
                      ChannelPromise promise) {

        ByteBuf buf = null;
        try {
            if (msg instanceof Iterable) {
                @SuppressWarnings("unchecked")
                Iterable<OFMessage> ofmsgs =  (Iterable<OFMessage>) msg;
                buf = ctx.alloc().ioBuffer();

                encode(ctx, ofmsgs, buf);

                if (buf.isReadable()) {
                    ctx.write(buf, promise);
                } else {

                    buf.release();
                    ctx.write(Unpooled.EMPTY_BUFFER, promise);
                }
                buf = null;

            } else {

                ctx.write(msg, promise);
            }
        } catch (EncoderException e) {

            throw e;
        } catch (Throwable e) {

            throw new EncoderException(e);
        } finally {
            if (buf != null) {
                buf.release();
            }
        }
    }

}

