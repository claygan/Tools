package com.quest.webservice.client;

import com.quest.entity.User;
import com.quest.webservice.HelloWorld;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

/**
 * Created by Quest on 2017/10/19.
 */
public class HelloWorldClient {
    public static void main(String[] args) {
        JaxWsProxyFactoryBean proxyFactoryBean = new JaxWsProxyFactoryBean();
        proxyFactoryBean.setServiceClass(HelloWorld.class);
        proxyFactoryBean.setAddress("http://localhost:8080/webservice/helloWorld");
        HelloWorld world = (HelloWorld) proxyFactoryBean.create();
        User user = new User();
        user.setUsername("库里");
        System.out.println(world.sayHiToUser(user));
    }
}
