package com.quest.test.io.NIO.client;

/**
 * Created by Quest on 2018/3/27.
 */
public class NioClient {
    public static void main(String[] args) {
        NioClientHandler clientHandler = new NioClientHandler("127.0.0.1", 8080);
        for (int i = 0; i < 10; i++) {
            new Thread(clientHandler, "NIO-client-001").start();
        }
    }
}
