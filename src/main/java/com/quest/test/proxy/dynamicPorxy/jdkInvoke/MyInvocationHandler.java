package com.quest.test.proxy.dynamicPorxy.jdkInvoke;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {
    private Object target;

    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        beforePerformance();
        Object reault = method.invoke(target, args);
        afterPerformance();
        return reault;
    }
    public void beforePerformance(){
        System.out.println("before：--------------------->");
    }
    public void afterPerformance(){
        System.out.println("after: <---------------------");
    }
}
