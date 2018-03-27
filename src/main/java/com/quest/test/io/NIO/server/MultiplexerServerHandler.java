package com.quest.test.io.NIO.server;

import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.sql.Date;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by Quest on 2018/3/23.
 */
public class MultiplexerServerHandler implements Runnable {
    private Selector selector;
    private ServerSocketChannel channel;
    private volatile boolean stop;

    public MultiplexerServerHandler(int port) {
        try {
            //打开一个channal
            channel = ServerSocketChannel.open();
            //配置为非阻塞模式
            channel.configureBlocking(false);
            //绑定监听的端口地址
            channel.socket().bind(new InetSocketAddress(port), 1204);
            //创建selector线程
            selector = Selector.open();
            channel.register(selector, SelectionKey.OP_ACCEPT);
            System.out.println("服务器启动，port："+port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void stop(){
        this.stop = true;
    }
    @Override
    public void run() {
        while (!stop) {
            try {
                //通过Selector循环准备就绪的Key
                selector.select();
                Set<SelectionKey> selectionKeys =   selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                SelectionKey selectionKey = null;
                while (iterator.hasNext()) {
                    selectionKey = iterator.next();
                    iterator.remove();
                    try {
                        handleInput(selectionKey);
                    } catch (Exception e) {
                        if (selectionKey != null) {
                            selectionKey.cancel();
                            if (selectionKey.channel() != null) {
                                selectionKey.channel().close();
                            }
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void handleInput(SelectionKey selectionKey) throws IOException {
        //可用状态
        if (selectionKey.isValid()) {
            //可接收状态
            if (selectionKey.isAcceptable()) {
                ServerSocketChannel server = (ServerSocketChannel) selectionKey.channel();
                //多路复用器监听新的客户端连接，处理连接请求，完成TCP三次握手
                SocketChannel client = server.accept();
                client.configureBlocking(false);
                //将新连接注册到多路复用器上，监听读操作，读取客户端发送的信息
                client.register(selector, SelectionKey.OP_READ);
            }
            //可读状态
            if (selectionKey.isReadable()) {
                SocketChannel client = (SocketChannel) selectionKey.channel();
                ByteBuffer buffer = ByteBuffer.allocate(1024);
                //读取客户端请求数据到缓冲区
                int count = client.read(buffer);//非阻塞
                if (count > 0) {
                    buffer.flip();
                    byte[] bytes = new byte[buffer.remaining()];
                    buffer.get(bytes);//缓冲区读取数据
                    String body = new String(bytes, "UTF-8");
                    System.out.println("[" + Thread.currentThread() + "],服务端读取：" + body);
                    //写回到客户端
                    String currentTime = "query time".equalsIgnoreCase(body) ? new Date(System.currentTimeMillis()).toString() : "BAD ORDER";
                    doWrite(client, currentTime);
                }else if(count < 0){
                    selectionKey.cancel();
                    client.close();
                }
            }
        }
    }

    private void doWrite(SocketChannel client, String content) throws IOException{
        if (StringUtils.isNotBlank(content)) {
            ByteBuffer sendBuffer = ByteBuffer.allocate(1024);
            sendBuffer.put(content.getBytes());
            sendBuffer.flip();
            //將响应消息写入到客户端channal
            client.write(sendBuffer);
            System.out.println("服务端向客户端发送数据--> " + content);
        }else{
            System.out.println("写入数据为空");
        }
    }
}

