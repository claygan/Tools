package com.quest.service;

/**
 * Created by Quest on 2017/9/1.
 */
public interface HandlerAware {
    void get();
    default void set(String num){
        System.out.println("set:"+num);
    }
    static void put(String input){
        System.out.println("put:"+input);
    }
}
