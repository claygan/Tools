package com.quest.test.io.BIO.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by Quest on 2018/3/23.
 */
public class BioClient {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            sendData();
        }
    }

    private static void sendData(){
        Socket socket = null;
        PrintWriter out = null;
        BufferedReader in = null;
        try {
            socket = new Socket("127.0.0.1", 8080);
            //发送请求到服务端
            out = new PrintWriter(socket.getOutputStream(), true);
            out.println("query time");
            System.out.println("向服务端发送了数据");

            //等待接收服务器返回数据
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String body = in.readLine();
            System.out.println("Now is "+body);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(out !=null){
                out.close();
                out = null;
            }
            if(socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                socket = null;
            }
        }
    }
}
