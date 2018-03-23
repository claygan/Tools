package com.quest.test.io.NIO.server;

import org.apache.ibatis.annotations.SelectKey;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

import static com.sun.org.apache.xml.internal.security.keys.keyresolver.KeyResolver.iterator;

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

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void handleInput(SelectionKey selectionKey) throws IOException {
        if (selectionKey.isValid()) {
            if (selectionKey.isAcceptable()) {
                ServerSocketChannel server = (ServerSocketChannel) selectionKey.channel();
                //多路复用器监听新的客户端连接，处理连接请求，完成TCP三次握手
                SocketChannel client = server.accept();
                client.configureBlocking(false);
                //将新连接注册到多路复用器上，监听读操作，读取客户端发送的信息
                client.register(selector, SelectionKey.OP_READ);
            }
            if (selectionKey.isReadable()) {
                SocketChannel client = (SocketChannel) selectionKey.channel();
                ByteBuffer buffer = ByteBuffer.allocate(1024);
                //读取客户端请求数据到缓冲区
                int count = client.read(buffer);//非阻塞
                if (count > 0) {

                }
            }
        }
    }
}
