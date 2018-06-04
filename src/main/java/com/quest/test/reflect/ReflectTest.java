package com.quest.test.reflect;

import com.quest.test.reflect.entity.OrderInfo;
import com.quest.test.reflect.object.Hello;
import com.quest.test.reflect.object.SayBye;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import static java.lang.reflect.Proxy.newProxyInstance;

/**
 * Created by Quest on 2018/3/14.
 */
public class ReflectTest {
    @Test
    public void getTitle(){
        OrderInfo order = new OrderInfo("123");
        System.out.println(order);
        addAreaTitle(order);
        System.out.println(order);
    }

    private void addAreaTitle(Object obj){
        try {
            Field areaCodeField = obj.getClass().getDeclaredField("areaCode");
            Field areaTitleField = obj.getClass().getDeclaredField("areaTitle");
            areaCodeField.setAccessible(true);
            areaTitleField.setAccessible(true);
            String areaCode = (String)areaCodeField.get(obj);
            if("123".equals(areaCode)){
                areaTitleField.set(obj,"浙江");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void invocationTest() throws Exception {
        Object obj = Class.forName("com.quest.test.reflect.object.HelloImpl").newInstance();
        InvocationHandler handler = new AopHandler(obj);
        Hello proxy = (Hello) Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), handler);
        proxy.sayHello();

    }

    @Test
    public void invoceMethod() throws Exception {
        Class cls = Class.forName("com.quest.test.reflect.enums.OrderStatusEnum");
        Method method = cls.getMethod("getTextByCode", String.class);
        String text = (String) method.invoke(null, "21");
        System.out.println(text);
    }
}
