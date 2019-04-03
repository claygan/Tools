package com.quest.web.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class OrderAspect {
    public void preProcess(){
        System.out.println("pre do something");
    }

    public void process(ProceedingJoinPoint point) throws Throwable {
        System.out.println("do before");
        point.proceed();
        System.out.println("do after");
    }
    public void afterProcess(){
        System.out.println("after do something");
    }
}
