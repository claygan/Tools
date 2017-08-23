package com.quest.test.concurrent;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by Quest on 2017/8/21.
 */
public class SemaphoreTest {
    @Test
    public void baseTest(){
        ExecutorService list = Executors.newCachedThreadPool();
        final Semaphore position = new Semaphore(1);
        list.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    position.acquire();
                    System.out.println(Thread.currentThread().getName() + "获取者阻塞");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        position.acquireUninterruptibly(1);
        System.out.println(Thread.currentThread().getName());
        System.out.println("availablePermits:"+position.availablePermits());
        System.out.println("drainPermits:"+position.drainPermits());
        System.out.println("getQueueLength:"+position.getQueueLength());
    }

    @Test
    public void test(){
        ExecutorService list = Executors.newCachedThreadPool();
        final Semaphore position = new Semaphore(2);
        for (int i = 0; i < 10; i++) {
            list.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        if (position.availablePermits() > 0) {
                            System.out.println(Thread.currentThread().getName()+"进来，位置为空!");
                        }else{
                            System.out.println(Thread.currentThread().getName()+"进来，没有位置，排队...");
                        }
                        position.acquire();
                        System.out.println(Thread.currentThread().getName()+"获得座位");
                        Thread.sleep((int)(Math.random()*1000));
                        System.out.println(Thread.currentThread().getName()+"离开座位");
                        position.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            });
        }
        list.shutdown();
        position.acquireUninterruptibly(2);
        System.out.println(Thread.currentThread().getName() + "客人全部离开了");
        position.release();
    }
}
