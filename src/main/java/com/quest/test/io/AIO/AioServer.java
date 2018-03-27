package com.quest.test.io.AIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Quest on 2018/3/27.
 */
public class AioServer {
    private final int port;

    public static void main(String[] args) {
        new AioServer(8080);
    }

    //注册一个端口，来给客户端连接
    public AioServer(int port) {
        this.port = port;
        litsen();
    }
    //监听
    private void litsen(){
        ExecutorService executorService = Executors.newCachedThreadPool();
        try {
            AsynchronousChannelGroup channelGroup = AsynchronousChannelGroup.withCachedThreadPool(executorService, 1);
            final AsynchronousServerSocketChannel server = AsynchronousServerSocketChannel.open(channelGroup);
            server.bind(new InetSocketAddress(port));
            System.out.println("服务启动，监听端口(" + port + ")");
            final Map<String, Integer> count = new ConcurrentHashMap<String, Integer>();
            count.put("count", 0);
            //开始等待客户端连接
            server.accept(null, new CompletionHandler<AsynchronousSocketChannel, Object>() {
                final ByteBuffer buffer = ByteBuffer.allocate(1024);

                /**
                 * io操作完成
                 */
                @Override
                public void completed(AsynchronousSocketChannel result, Object attachment) {
                    count.put("count", count.get("count") + 1);
                    System.out.println(count.get("count"));

                    try {
                        buffer.clear();
                        result.read(buffer).get();
                        buffer.flip();
                        result.write(buffer);
                        buffer.flip();
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            result.close();
                            server.accept(null, this);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }

                /**
                 * io操作失败
                 */
                @Override
                public void failed(Throwable exc, Object attachment) {
                    System.out.println("IO失败：" + exc);
                }
            });
            try {
                Thread.sleep(Integer.MAX_VALUE);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
