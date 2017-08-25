package com.quest.test.concurrent;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by Quest on 2017/8/21.
 */
public class SemaphoreTest {
    private static Semaphore semaphore = new Semaphore(10);

    @Test
    public void baseTest(){
        final Semaphore position = new Semaphore(1);
        try {
            System.out.println("before:"+position.availablePermits());
            position.acquire();
            System.out.println("acquire:"+position.availablePermits());
            System.out.println("wait for release...");
            Thread.sleep(2000);
            position.release();
            System.out.println("release:"+position.availablePermits());
        } catch (InterruptedException e) {
            e.printStackTrace();
            position.release();
        }

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

    @Test
    public void test1(){
        final int THREAD_COUNT = 30;
        ExecutorService threadpool = Executors.newFixedThreadPool(THREAD_COUNT);
        for (int i = 0; i < THREAD_COUNT; i++) {
            threadpool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        semaphore.acquireUninterruptibly();
                        Thread.currentThread().sleep(2000);
                        System.out.println(Thread.currentThread().getName() + ":save Data");
                        semaphore.release();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        while(semaphore.hasQueuedThreads()){
        }
        semaphore.acquireUninterruptibly(10);
        System.out.println("all is over");
        threadpool.shutdown();
    }
}
