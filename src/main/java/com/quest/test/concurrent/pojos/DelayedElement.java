package com.quest.test.concurrent.pojos;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * Created by Quest on 2017/8/25.
 */
public class DelayedElement implements Delayed {
    private long expired;
    private long delay;
    private String name;

    public DelayedElement(String elementName, long delay) {
        this. name = elementName;
        this. delay= delay;
        expired = ( delay + System. currentTimeMillis());
    }

    @Override
    public int compareTo(Delayed o) {
        DelayedElement cached=(DelayedElement) o;
        return cached.getExpired()> expired?1:-1;
    }

    @Override
    public long getDelay(TimeUnit unit) {

        return ( expired - System. currentTimeMillis());
    }

    @Override
    public String toString() {
        return "DelayedElement [delay=" + delay + ", name=" + name + "]";
    }

    public long getExpired() {
        return expired;
    }

}