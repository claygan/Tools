package com.quest.test.queue.delayQueue;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class Message implements Delayed {
    private String msgId;
    private String context;
    private long expired;

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public long getExpired() {
        return expired;
    }

    public Message(String msgId, String context, long delayTime) {
        this.msgId = msgId;
        this.context = context;
        this.expired = TimeUnit.NANOSECONDS.convert(delayTime,TimeUnit.MILLISECONDS) + System.nanoTime();
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(expired - System.nanoTime(), TimeUnit.NANOSECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        if(o == null){
            return 1;
        }else if(o == this){
            return 0;
        } else if (o instanceof Message) {
            Message msg = (Message) o;
            return this.getExpired() > msg.getExpired()?1 :(this.getExpired() < msg.getExpired() ? -1 : 0);
        }else{
            throw new IllegalArgumentException();
        }
    }
}
