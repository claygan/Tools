package com.quest.test.io.NIO.client;

import org.apache.ibatis.annotations.SelectKey;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

import static com.sun.org.apache.xml.internal.security.keys.keyresolver.KeyResolver.iterator;

/**
 * Created by Quest on 2018/3/27.
 */
public class NioClientHandler implements Runnable {
    private String host;
    private int port;
    private SocketChannel socketChannel;
    private Selector selector;
    private volatile boolean stop;

    public NioClientHandler(String host, int port) {
        this.host = host;
        this.port = port;
        try {
            //打开channal
            socketChannel = SocketChannel.open();
            //打开多路复用器
            selector = Selector.open();
            //设置channal为非阻塞
            socketChannel.configureBlocking(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            doConnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        while (!stop) {
            //轮询通道状态
            try {
                selector.select(1000);
                Set<SelectionKey> selectKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectKeys.iterator();
                SelectionKey selectionKey = null;
                while (iterator.hasNext()) {
                    selectionKey = iterator.next();
                    iterator.remove();
                    try {
                        handlerInput(selectionKey);
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

    private void handlerInput(SelectionKey selectionKey)throws Exception{
        if (selectionKey.isValid()) {
            SocketChannel client = (SocketChannel) selectionKey.channel();
            if (selectionKey.isConnectable()) {
                if (client.finishConnect()) {
                    //客户端完成连接，重新注册可读
                    socketChannel.register(selector, SelectionKey.OP_READ);
                    doWrite(client);
                }else{
                    System.exit(1);
                }
            }
            if (selectionKey.isReadable()) {
                ByteBuffer readBuffer = ByteBuffer.allocate(1024);
                int count = client.read(readBuffer);
                if (count > 0) {
                    readBuffer.flip();
                    byte[] bytes = new byte[readBuffer.remaining()];
                    readBuffer.get(bytes);
                    String body = new String(bytes, "UTF-8");
                    System.out.println("read data: " + body);
                    this.stop = true;
                }else if(count < 0){
                    selectionKey.cancel();
                    client.close();
                }
            }
        }
    }

    private void doConnect() throws Exception{
        boolean connet = socketChannel.connect(new InetSocketAddress(host, port));
        if (connet) {
            //连接成功，注册到selector为可读状态
            socketChannel.register(selector, SelectionKey.OP_READ);
            doWrite(socketChannel);
        }else{
            //连接不成功，向selector注册连接状态
            socketChannel.register(selector, SelectionKey.OP_CONNECT);
        }
    }

    private void doWrite(SocketChannel channel) throws IOException {
        ByteBuffer sendBuffer = ByteBuffer.allocate(1024);
        sendBuffer.put("query time".getBytes());
        sendBuffer.flip();
        channel.write(sendBuffer);
        if (!sendBuffer.hasRemaining()) {
            System.out.println("send to server success!");
        }
    }
}
