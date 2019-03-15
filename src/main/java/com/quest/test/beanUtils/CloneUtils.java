package com.quest.test.beanUtils;

import com.quest.test.beanUtils.entitys.Element;
import com.quest.test.beanUtils.entitys.Product;

/**
 * jdk提供的Cloneable方法，浅拷贝和深拷贝（内部对象也需要拷贝）
 */
public class CloneUtils {
    public static void main(String[] args) {

        Product p1 = new Product("stick", 12, new Element("Bamboo", 2));
        System.out.println(p1);
        Product p2 = p1.clone();
        System.out.println(p2);
        System.out.println("p1==p2:"+(p1==p2));
        System.out.println("name1==name2:"+(p1.getName()==p2.getName()));//String同一个对象
        System.out.println("length1==length2:"+(p1.getLength()==p2.getLength()));//int同一个值
        System.out.println("element1==element2:"+(p1.getElement()==p2.getElement()));//Object同一个对象(如果也实现clonable，那就是新对象，不是新引用了)
    }
}
