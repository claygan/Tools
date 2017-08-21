package com.quest.test;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.Currency;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by Quest on 2017/8/17.
 */
public class ThreadpoolTest {
    @Test
    public void semaphoreTest() {
        int concurrency = 500;
        ExecutorService executorService = Executors.newFixedThreadPool(concurrency);
        //维护一个许可集
        final Semaphore semaphore = new Semaphore(concurrency);
        List<String> list = Lists.newArrayList();
        List<Runnable> runnables = Lists.newArrayList();
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
        System.out.println(Thread.currentThread().getName() + ":" + list.size());
    }

}
