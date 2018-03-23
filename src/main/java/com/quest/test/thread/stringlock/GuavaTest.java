package com.quest.test.thread.stringlock;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * Created by Quest on 2018/2/27.
 */
public class GuavaTest {
    private static final int THREAD_COUNT = 5;
    public static void main(String[] args) {
        LoadingCache<String, String> cache = CacheBuilder.newBuilder()
                .expireAfterWrite(10, TimeUnit.SECONDS)
                .build(new CacheLoader<String, String>() {
                    @Override
                    public String load(String ip) throws Exception {
                        String cookie = request(ip);
                        return cookie;
                    }
                });
        try {
            cache.put("ip-1","1");
            System.out.println(cache.get("ip-1"));
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        //
        Thread[] threads = new Thread[THREAD_COUNT];
        for (int i = 0, len = threads.length; i < len; i++) {
            threads[i] = new Thread(new GuavaThread(cache,"192.168.1.1"));
        }
        for (int i = 0; i < THREAD_COUNT; i++) {
            threads[i].start();
        }
    }

    private static String request(String ip){
        return "ip-" + ip;
    }
}
