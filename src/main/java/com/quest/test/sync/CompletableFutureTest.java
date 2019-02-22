package com.quest.test.sync;

import org.apache.commons.lang3.time.StopWatch;
import org.junit.Test;

import java.util.concurrent.*;

/**
 * CompletableFuture 是 Doug Lea 的又一力作，彻底解决了 Future 的缺陷，把 Java 带入了异步响应式编程的新世界
 */
public class CompletableFutureTest {
    private int event1(){
        try {
            Thread.sleep(3000);
            return 1;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 0;
    }
    private int event2(){
        try {
            Thread.sleep(3000);
            return 2;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 0;
    }
    private int event3(){
        try {
            Thread.sleep(3000);
            return 3;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 0;
    }
    /**
     * 1.模拟传统rpc方法调用，顺序执行接口，总耗时>=每个rpc接口耗时总和
     */
    private int execute1(){
        int e1 = event1();
        int e2 = event2();
        int e3 = event3();
        int result = e1+e2+e3;
        return result;
    }
    /**
     * 2.使用future，优化多个rpc调用，总耗时≈每个rpc接口耗时，但是占用线程资源较多
     * future局限性：
     *  1.无法将两个异步计算的结果合并为一个。
     *  2.等待Future集合中所有任务完成。
     *  3.等待Future集合中最快任务完成（选择最优的执行方案）。
     *  4.通过编程的方式完成一个Future任务的执行（手工设定异步结果处理）。
     *  5.应对Future的完成事件，当Future的完成事件发生时会收到通知，并可以使用Future的结果进行下一步操作，不只是简单的阻塞等待。
     */
    private int execute2(){
        ExecutorService executor = Executors.newFixedThreadPool(3);
        Future<Integer> f1 = executor.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Thread.sleep(3000);
                return 1;
            }
        });
        Future<Integer> f2 = executor.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Thread.sleep(3000);
                return 2;
            }
        });
        Future<Integer> f3 = executor.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Thread.sleep(3000);
                return 3;
            }
        });
        int result = 0;
        try {
            result = f1.get()+f2.get()+f3.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return result;
    }
    /**
     * 3.
     */
    private int execute3(){
        CompletableFuture<Integer> c1 = CompletableFuture.supplyAsync(()->{
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 100;
        });

        int result = 0;
        return result;
    }
    @Test
    public void test(){
        StopWatch watch = new StopWatch();
        watch.start();
        System.out.println(execute2());
        watch.stop();
        System.out.println(watch.getTime()+"ms");
    }
}
