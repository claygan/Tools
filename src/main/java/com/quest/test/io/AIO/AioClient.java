package com.quest.test.io.AIO;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;

/**
 * Created by Quest on 2018/3/27.
 */
public class AioClient {
    private final AsynchronousSocketChannel client;

    public AioClient()throws Exception {
        client = AsynchronousSocketChannel.open();
    }

    public void connect(String host, int port)throws Exception {
        //匿名接口，写操作
        client.connect(new InetSocketAddress(host, port), null, new CompletionHandler<Void, Object>() {

            @Override
            public void completed(Void result, Object attachment) {
                try {
                    client.write(ByteBuffer.wrap(("发送一条测试数据" + System.currentTimeMillis()).getBytes())).get();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void failed(Throwable exc, Object attachment) {
                exc.printStackTrace();
            }
        });
        //读操作
        final ByteBuffer buffer = ByteBuffer.allocate(1024);
        client.read(buffer, null, new CompletionHandler<Integer, Object>() {
            @Override
            public void completed(Integer result, Object attachment) {
                System.out.println("读取数据："+new String(buffer.array()));
            }

            @Override
            public void failed(Throwable exc, Object attachment) {
                exc.printStackTrace();
            }
        });

        try {
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws InterruptedException {
        int count = 3;
        final CountDownLatch latch = new CountDownLatch(count);
        for (int i = 0; i < count; i++) {
            latch.countDown();
            new Thread(){
                public void run(){
                    try {
                        latch.await();
                        new AioClient().connect("127.0.0.1", 8080);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        }
        Thread.sleep(1000 * 60 * 10);
    }

}
