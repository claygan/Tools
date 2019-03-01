package com.quest.test.queue.delayQueue;

import java.time.LocalTime;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.TimeUnit;

public class MessageConsumer implements Runnable {
    private DelayQueue<Message> queue;

    public MessageConsumer(DelayQueue<Message> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while(true){
            try {
                Message message = queue.take();
                System.out.println("消费消息：id="+message.getMsgId()+",content:"+message.getContext());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
