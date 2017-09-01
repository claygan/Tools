package com.quest.service.impl;

import com.quest.service.HandlerAware;

/**
 * Created by Quest on 2017/9/1.
 */
public class HandlerAwareImpl implements HandlerAware {
    @Override
    public void get() {
        System.out.println("use the get method");
    }

}
