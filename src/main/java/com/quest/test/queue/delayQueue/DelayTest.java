package com.quest.test.queue.delayQueue;

import java.util.concurrent.*;

public class DelayTest {
    public static void main(String[] args) {
        Message m1 = new Message("30", "curry", 3000L);
        Message m2 = new Message("8", "kobe", 2000L);
        Message m3 = new Message("23", "james", 100L);
        DelayQueue<Message> queue = new DelayQueue<>();
        queue.offer(m3);
        queue.offer(m1);
        queue.offer(m2);
        //线程执行
        ExecutorService exec = Executors.newFixedThreadPool(1);
        exec.submit(new MessageConsumer(queue));
    }
}
