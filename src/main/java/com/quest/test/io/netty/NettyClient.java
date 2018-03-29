package com.quest.test.io.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.FixedLengthFrameDecoder;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

/**
 * Created by Quest on 2018/3/27.
 */
public class NettyClient {
    public static void main(String[] args) throws Exception{
        new NettyClient().connect("127.0.0.1",8080);
    }

    private void connect(String host, int port) throws Exception {
        EventLoopGroup group = new NioEventLoopGroup();

        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(group)
                    .channel(NioSocketChannel.class)//指定channel类型
                    .option(ChannelOption.TCP_NODELAY, true)//配置channel的tcp网络协议
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            //解决粘包拆包问题
//                            ByteBuf delimiter = Unpooled.copiedBuffer("$_".getBytes());
//                            socketChannel.pipeline().addLast(new DelimiterBasedFrameDecoder(1024, delimiter));//自定义
//                            socketChannel.pipeline().addLast(new FixedLengthFrameDecoder(10));//定长
                            socketChannel.pipeline().addLast(new LineBasedFrameDecoder(1024));//换行符\n
                            socketChannel.pipeline().addLast(new StringDecoder());
                            socketChannel.pipeline().addLast(new NettyClientHandler());//初始化绑定io事件处理类
                        }
                    });
            //发起异步连接操作
            ChannelFuture future = bootstrap.connect(host, port).sync();
            //等待客户端链路关闭
            future.channel().closeFuture().sync();
        } finally {
            group.shutdownGracefully();
        }
    }
}
