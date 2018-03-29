package com.quest.test.io.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

import java.sql.Date;

/**
 * Created by Quest on 2018/3/27.
 */
public class NettyServerHandler extends ChannelHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        /*ByteBuf buf = (ByteBuf) msg;
        byte[] req = new byte[buf.readableBytes()];
        buf.readBytes(req);
        String body = new String(req, "UTF-8");*/
        String body = (String) msg;
        System.out.println("[" + Thread.currentThread() + "]--接收到数据：" + body);
        String currentTime = "query time".equalsIgnoreCase(body) ? new Date(System.currentTimeMillis()).toString() : "bad order";
//        currentTime += "$_";
        currentTime += System.getProperty("line.separator");
        ByteBuf resp = Unpooled.copiedBuffer(currentTime.getBytes());
        //将待发送的消息放到发送缓冲区中
        ctx.writeAndFlush(resp);
    }
}
