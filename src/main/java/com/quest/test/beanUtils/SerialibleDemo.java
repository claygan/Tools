package com.quest.test.beanUtils;

import com.quest.test.beanUtils.entitys.Goods;
import com.quest.test.beanUtils.entitys.Package;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.poi.ss.formula.functions.T;
import org.junit.Test;

import java.io.*;
import java.lang.reflect.InvocationTargetException;

/**
 *  利用序列化的方式可以进行对象拷贝
 */
public class SerialibleDemo {
    public static void main(String[] args) {
        Package p1 = new Package("fruit", 12, new Goods("apple", 24));
        System.out.println(p1);

        //Package p2 = copy(p1);//Serialible序列化方式
        Package p2 = apacheBeanutils(p1);
        System.out.println(p2);
        System.out.println("pname1=pname2: "+(p1.getName()==p2.getName()));
        System.out.println("pgoods1=pgoods2: "+(p1.getGoods()==p2.getGoods()));
        p2.setGoods(p2.getGoods().setCate("banana"));
        System.out.println(p1);
        System.out.println(p2);

    }

    private static <T extends Serializable>T copy(T o){
        ByteArrayOutputStream byteOut = null;
        ObjectOutputStream outputStream = null;
        ByteArrayInputStream byteIn = null;
        ObjectInputStream inputStream = null;
        try {
            byteOut = new ByteArrayOutputStream();
            outputStream = new ObjectOutputStream(byteOut);
            //
            outputStream.writeObject(o);
            byteIn =  new ByteArrayInputStream(byteOut.toByteArray());
            inputStream = new ObjectInputStream(byteIn);
            return (T)inputStream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            byteOut = null;
            byteIn = null;
            if(outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    /**
     * apache提供的beanutils实际上是浅拷贝，引用类型对象实际上指向的是同一个对象
     */
    public static <T>T apacheBeanutils(T o){
        Package d = new Package();
        try {
            BeanUtils.copyProperties(d, o);
            return (T)d;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}
