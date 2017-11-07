package com.quest.webservice.app;

import com.quest.webservice.HelloWorld;
import com.quest.webservice.impl.HelloWordImpl;

import javax.xml.ws.Endpoint;

/**
 * Created by Quest on 2017/10/19.
 */
public class WebServiceApp {
    public static void main(String[] args) {
        System.out.println("service start.....");
        HelloWorld world = new HelloWordImpl();
        String address = "http://localhost:8080/webservice/helloWorld";
        Endpoint.publish(address, world);
        System.out.println("service started!");
    }
}
