package com.quest.test.io.BIO.server;

import javax.naming.ldap.SortKey;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.Date;

/**
 * Created by Quest on 2018/3/23.
 */
public class BioServerHandler implements Runnable {
    private Socket socket;
    public BioServerHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        BufferedReader in = null;
        PrintWriter out = null;
        try {
            in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
            String body = null;
            String result = null;
            while (true) {
                body = in.readLine();//阻塞等待数据可以被读取
                if (body == null) {
                    break;
                }
                System.out.println("[" + Thread.currentThread() + "]->服务器接收到数据：" + body);
                result = "query time".equalsIgnoreCase(body) ? new Date(System.currentTimeMillis()).toString() : "BAD ORDER";
                //返回结果给客户端
                out.println(result);
            }
        } catch (IOException e) {
            if(in != null){
                try {
                    in.close();
                    in = null;//
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            if(out != null){
                try {
                    out.close();
                    out = null;//
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
            if(socket != null){
                try {
                    socket.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                this.socket = null;
            }
        }

    }
}
