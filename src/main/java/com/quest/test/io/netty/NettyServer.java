package com.quest.test.io.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.FixedLengthFrameDecoder;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

/**
 * Created by Quest on 2018/3/27.
 */
public class NettyServer {
    public static void main(String[] args)throws Exception {
        new NettyServer().bind(8080);
    }
    private void bind(int port) throws Exception{
        //1.用于服务端接收客户端的连接
        EventLoopGroup acceptorGroup = new NioEventLoopGroup();
        //2.用于进行socketChannel网络读写
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            //Netty用于启动NIO服务的辅助启动类
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(acceptorGroup, workerGroup)//将两个NIO线程组加入到辅助启动类中
                    .channel(NioServerSocketChannel.class)//设置创建的channel类型
                    .option(ChannelOption.SO_BACKLOG, 1024)//配置NioServerSocketChannel的tcp参数
                    .childHandler(new ChannelInitializer<SocketChannel>() {//设置绑定io事件的处理类
                        //创建NioServerSocketChannel成功后，进行初始化时，将channelHandler设置到channelPipeline中，用于处理网络事件
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            //解决粘包拆包问题
//                            ByteBuf delimiter = Unpooled.copiedBuffer("$_".getBytes());
//                            socketChannel.pipeline().addLast(new DelimiterBasedFrameDecoder(1024, delimiter));//自定义分隔符作为消息结束方式
//                            socketChannel.pipeline().addLast(new FixedLengthFrameDecoder(10));//定长分隔符
                            socketChannel.pipeline().addLast(new LineBasedFrameDecoder(1024));//换行符\n
                            socketChannel.pipeline().addLast(new StringDecoder());
                            socketChannel.pipeline().addLast(new NettyServerHandler());
                        }
                    });
            //绑定端口，同步等待成功（sync：同步阻塞方法，等待bind完毕才能继续）
            // ChannelFuture主要用于异步通知回调
            ChannelFuture future = bootstrap.bind(port).sync();
            System.out.println("服务器启动成功，端口(" + port + ")");
            //等待服务端监听端口关闭
            future.channel().closeFuture().sync();
        }finally {
            //优雅退出，释放线程池资源
            acceptorGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
