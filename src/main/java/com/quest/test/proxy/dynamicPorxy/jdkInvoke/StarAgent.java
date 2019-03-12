package com.quest.test.proxy.dynamicPorxy.jdkInvoke;

import java.lang.reflect.Proxy;

public class StarAgent {
    public static Object proxy(Object target) {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new MyInvocationHandler(target));
    }
}
