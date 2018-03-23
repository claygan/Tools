package com.quest.test.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by Quest on 2018/3/16.
 */
public class AopHandler implements InvocationHandler {
    private Object target;

    public AopHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("proxy:"+proxy.getClass().getName());
        System.out.println("method:"+method.getClass().getName());
        return method.invoke(target, args);
    }
}
