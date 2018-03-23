package com.quest.test.thread.stringlock;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * Created by Quest on 2018/2/27.
 */
public class GuavaThread implements Runnable {

    private String ip;
    LoadingCache<String, String> cache;

    public GuavaThread(LoadingCache<String, String> cache, String ip) {
        this.ip = ip;
        this.cache = cache;
    }

    @Override
    public void run() {
        try {
            cache.put("ip-"+ip,Math.random()+"");
            System.out.println("[" + Thread.currentThread().getName() + "]存入"+ip);
            Thread.sleep(5000);
            System.out.println("[" + Thread.currentThread().getName() + "]取出"+cache.get("ip-"+ip));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
