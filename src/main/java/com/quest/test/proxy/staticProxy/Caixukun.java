package com.quest.test.proxy.staticProxy;

public class Caixukun implements Star {
    @Override
    public boolean performance(int money) {
        if (money > 100) {
            System.out.println("√√√√√√ I'm Caixukun, I performed an basketball dance for you.");
            return true;
        }
        System.out.println("×××××××× I'm Caixukun, I need more money");
        return false;
    }
}
