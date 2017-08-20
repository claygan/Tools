package com.quest.test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gansm on 2017-07-30 0030.
 */
public class ForEachTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        System.out.println("add_start:"+System.currentTimeMillis());
        for (int i = 0; i < 100; i++) {
            list.add(i+"");
        }
        System.out.println("add_end:" + System.currentTimeMillis());
        //old
        /*long start = System.currentTimeMillis();
        System.out.println("find_start:" + start);
        for (String str : list){
            System.out.print(str+"");
        }
        System.out.println();
        long end = System.currentTimeMillis();
        System.out.println("find_end:" + end);
        System.out.println("总耗时："+(end-start));*/
        //new
        /*long start = System.currentTimeMillis();
        System.out.println("find_start:" + start);
        list.forEach(i-> System.out.print(i+""));
        System.out.println();
        long end = System.currentTimeMillis();
        System.out.println("find_end:" + end);
        System.out.println("总耗时："+(end-start));*/
        //new2
        long start = System.currentTimeMillis();
        System.out.println("find_start:" + start);
        list.forEach(System.out::print);
        System.out.println();
        long end = System.currentTimeMillis();
        System.out.println("find_end:" + end);
        System.out.println("总耗时："+(end-start));
    }
}
