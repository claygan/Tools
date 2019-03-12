package com.quest.test.proxy.staticProxy;

public class Wuyifan implements Star {
    @Override
    public boolean performance(int money) {
        if (money > 1) {
            System.out.println("√√√√√√ I'm Wuyifan, I will performe an awkward dance.");
            return true;
        }
        System.out.println("×××××××× I'm Wuyifan, I need more money");
        return false;
    }
}
