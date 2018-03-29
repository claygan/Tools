package com.quest.test.io.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * Created by Quest on 2018/3/27.
 */
public class NettyClientHandler extends ChannelHandlerAdapter {
    /**
     * 向服务端发送指令
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        //出现粘包，拆包问题
        ByteBuf buf = null;
        for (int i = 0; i < 5; i++) {
//            byte[] req = ("query time"+"$_").getBytes();//自定义结束符
//            byte[] req = ("query time").getBytes();
            byte[] req = ("query time"+System.getProperty("line.separator")).getBytes();
            buf = Unpooled.buffer(req.length);
            buf.writeBytes(req);
            ctx.writeAndFlush(buf);
        }
    }

    /**
     * 从服务端读取数据
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        /*ByteBuf buf = (ByteBuf) msg;
        byte[] req = new byte[buf.readableBytes()];
        buf.readBytes(req);
        String body = new String(req, "UTF-8");*/
        String body = (String) msg;
        System.out.println("接收到服务端返回的数据：" + body);
    }

    /**
     * 异常调用
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();//释放资源
    }
}
