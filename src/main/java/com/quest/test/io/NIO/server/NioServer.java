package com.quest.test.io.NIO.server;

/**
 * Created by Quest on 2018/3/23.
 */
public class NioServer {
    public static void main(String[] args) {
        int port = 8080;
        MultiplexerServerHandler serverHandler = new MultiplexerServerHandler(port);
        new Thread(serverHandler,"NIO-Server-001").start();
    }
}
