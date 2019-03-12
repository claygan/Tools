package com.quest.test.proxy.staticProxy;

public class Fans {
    private int money;
    private int skillLevel;

    public Fans(int money, int skillLevel) {
        this.money = money;
        this.skillLevel = skillLevel;
    }

    public void seeIdol(Star star) {
        star.performance(money);
    }
    public void playWithPlayer(Player player){
        player.play(skillLevel);
    }

    public static void main(String[] args) {
        Fans a = new Fans(1,97);

        StarAgent agent = new StarAgent(new Wuyifan());
        a.seeIdol(agent);
        StarAgent a2 = new StarAgent(new Caixukun());
        a.seeIdol(a2);

        StarAgent a3 = new StarAgent(new Curry());
        a.playWithPlayer(a3);
    }
}
