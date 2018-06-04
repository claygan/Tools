package com.quest.test.guava.eventBus;

/**
 * Created by Quest on 2018/6/4.
 */
public class TestDemo {
    public static void main(String[] args) {
        Observer1 observer1 = new Observer1();
        Observer2 observer2 = new Observer2();
        EventBusCenter.register(observer1);
        EventBusCenter.register(observer2);
        System.out.println("===============start================");
        EventBusCenter.post("post a string msg!");
        EventBusCenter.post(123);
        EventBusCenter.post(new DataEntity("curry",30,"PG"));
        System.out.println("===============after unregister==================");
        EventBusCenter.unRegister(observer2);
        EventBusCenter.post("post a string msg!");
        EventBusCenter.post(123);
        System.out.println("===============end================");
    }
}
