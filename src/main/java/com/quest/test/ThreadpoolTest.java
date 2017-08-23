package com.quest.test;

import com.google.common.collect.Lists;
import com.google.common.util.concurrent.Uninterruptibles;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 解决问题：当一个线程池创建一组线程操作同一个对象，然后主线程获取最终准确结果
 */
public class ThreadpoolTest {
    private final static int concurrency = 500;
    ExecutorService executorService = Executors.newFixedThreadPool(concurrency);
    /**
     *@Description: 利用Semaphore计数信号量类，concurruent提供的一个针对线程的计数类，可以维护一组许可证
     * 每个线程中可以添加一个许可证release(),在外部acquire()获取之前都将一直阻塞
     * concurrency=500：总耗时（130ms~180ms）
     */
    @Test
    public void semaphoreTest() {
        //维护一个许可集
        final Semaphore semaphore = new Semaphore(concurrency);
        List<String> list = Lists.newArrayList();
        List<Runnable> runnables = Lists.newArrayList();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < concurrency; i++) {
            runnables.add(new Runnable() {
                @Override
                public void run() {
                    list.add("a");
                    semaphore.release();//释放许可
                    System.out.println(Thread.currentThread().getName() + ":" + list.size());
                }
            });
        }
        System.out.println(Thread.currentThread().getName() + ":" + list.size());
        for (Runnable runnable : runnables) {
            semaphore.acquireUninterruptibly();//获取一个许可证
            executorService.execute(runnable);
        }
        //等待任务完成
        semaphore.acquireUninterruptibly(concurrency);
        long endTime = System.currentTimeMillis();
        System.out.println(Thread.currentThread().getName() + ":" + list.size()+",总耗时：【"+(endTime- startTime)+"ms】");
        //用完清理list
        list.clear();
    }

    /**
     *@Description: 利用原子类，每个线程执行增加计数，主线程进入死循环判断计数是否达到总数，完全编码实现阻塞
     * concurrency=500：总耗时：340ms~550ms（效率较低，时间大部分稳定在340左右）
     */
    @Test
    public void automicSolveTest(){
        final AtomicInteger countSum = new AtomicInteger(0);
        List<String> list = Lists.newArrayList();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < concurrency; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    list.add("a");
                    countSum.incrementAndGet();
                    System.out.println(Thread.currentThread().getName() + ":" + list.size());
                }
            });
        }
        //编码阻塞
        while (countSum.get() != concurrency) {
            try {
                Thread.sleep(200);
                System.out.println("wait 200ms...");
            } catch (InterruptedException e) {
                continue;
            }
        }
        long endTime = System.currentTimeMillis();
        //任务完成
        System.out.println(Thread.currentThread().getName() + ":" + list.size()+",总耗时：【"+(endTime- startTime)+"ms】");
        //用完清理list
        list.clear();
    }

    /**
     *@Description: CountDownLatch:允许一个或多个线程等待直到在其他线程中执行的一组操作完成的同步辅助
     * 就相当于先维护一个执行线程总数，每执行一个线程减去一次countDown，在等于0之前阻塞
     * concurrency=500：总耗时：150ms~522ms（效率较低,时间波动比较大）
     */
    @Test
    public void countDownLatchTest() {
        final CountDownLatch latch = new CountDownLatch(concurrency);
        List<String> list = Lists.newArrayList();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < concurrency; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    list.add("a");
                    System.out.println(Thread.currentThread().getName() + ":" + list.size());
                    latch.countDown();
                }
            });
        }
        System.out.println("wait for task finish...");
        Uninterruptibles.awaitUninterruptibly(latch);
        long endTime = System.currentTimeMillis();
        //任务完成
        System.out.println(Thread.currentThread().getName() + ":" + list.size()+",总耗时：【"+(endTime- startTime)+"ms】");
        //用完清理list
        list.clear();
    }

}
