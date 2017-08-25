package com.quest.test.concurrent;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Quest on 2017/8/25.
 */
public class CountDownLatchTest {
    /**
     *@Description: 跑步问题
     */
    @Test
    public void test() throws InterruptedException {
        final CountDownLatch start = new CountDownLatch(1);
        final CountDownLatch end = new CountDownLatch(10);
        final ExecutorService service = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            final int INDEX = i + 1;
            service.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        start.await();
                        Thread.currentThread().sleep((long)Math.random()*10000);
                        System.out.println("NO." + INDEX + "arrived");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        end.countDown();
                    }
                }
            });
        }
        System.out.println("Game start");
        start.countDown();
        end.await();
        System.out.println("Game over");
        service.shutdown();
    }
}
