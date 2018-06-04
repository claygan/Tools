package com.quest.test.guava.eventBus;

import com.google.common.eventbus.Subscribe;

/**
 * Created by Quest on 2018/6/4.
 */
public class Observer1 {
    @Subscribe
    public void func(String msg) {
        System.out.println("String Msg:" + msg);
    }
    @Subscribe
    public void func2(Integer msg) {
        System.out.println("Integer1 Msg:" + msg);
    }
    @Subscribe
    public void func3(DataEntity msg) {
        System.out.println("DataEntity Msg:" + msg);
    }

}
