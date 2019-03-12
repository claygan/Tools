package com.quest.test.proxy.staticProxy;

public class StarAgent implements Star,Player {
    private Star star;
    private Player player;
    public StarAgent(Star star) {
        this.star = star;
    }

    public StarAgent(Player player) {
        this.player = player;
    }

    @Override
    public boolean performance(int money) {
        beforePerformance();
        boolean result = star.performance(money);
        afterPerformance();
        return result;
    }
    public void beforePerformance(){
        System.out.println("before：=====================>");
    }
    public void afterPerformance(){
        System.out.println("after: <=====================");
    }

    @Override
    public boolean play(int skilLevel) {
        beforePerformance();
        boolean result = player.play(skilLevel);
        afterPerformance();
        return result;
    }
}
