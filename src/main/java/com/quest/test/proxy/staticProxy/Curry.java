package com.quest.test.proxy.staticProxy;

public class Curry implements Player {
    @Override
    public boolean play(int skilLevel) {
        if (skilLevel > 95) {
            System.out.println("oh,yes !!!I'm curry. you play so good!");
            return true;
        }
        System.out.println("no no no!I'm curry. you are so dish");
        return false;

    }
}
