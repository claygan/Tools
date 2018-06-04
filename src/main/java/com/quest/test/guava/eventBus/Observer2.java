package com.quest.test.guava.eventBus;

import com.google.common.eventbus.Subscribe;

/**
 * Created by Quest on 2018/6/4.
 */
public class Observer2 {
    @Subscribe
    public void func(Integer msg) {
        System.out.println("Integer Msg:" + msg);
    }
}
