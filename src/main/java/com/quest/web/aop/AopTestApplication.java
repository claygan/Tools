package com.quest.web.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class AopTestApplication {
    public static void main(String[] args) {
        ApplicationContext context = new GenericXmlApplicationContext("spring-aop.xml");
        OrderService bean = context.getBean(OrderService.class);
        bean.createOrder();
    }
}
