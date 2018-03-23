package com.quest.test.io.BIO.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Quest on 2018/3/23.
 */
public class BioServer {
    public static void main(String[] args) {
        int port = 8080;
        ServerSocket server = null;
        try {
            server = new ServerSocket(port);
            Socket socket = null;
            ServerHandlerExecutepool executepool = new ServerHandlerExecutepool(50, 10000);
            while (true) {
                socket = server.accept();
                //单线程效率低下
//                new Thread(new BioServerHandler(socket)).start();
                //线程池在一定程度上会大大提高多客户端情况下的执行效率,这种叫：“伪异步IO模型”
                executepool.execute(new BioServerHandler(socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (server != null) {
                System.out.println("关闭了服务！");
                try {
                    server.close();
                    server = null;
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
