package com.quest.test.io.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

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
