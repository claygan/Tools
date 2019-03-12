package com.quest.test.proxy.dynamicPorxy.jdkInvoke;

import com.quest.test.proxy.staticProxy.*;

public class Performance {
    public static void main(String[] args) {
        Fans a = new Fans(2, 94);
        Star agent = (Star)StarAgent.proxy(new Wuyifan());
        a.seeIdol(agent);

        Player p = (Player) StarAgent.proxy(new Curry());
        a.playWithPlayer(p);
    }
}
