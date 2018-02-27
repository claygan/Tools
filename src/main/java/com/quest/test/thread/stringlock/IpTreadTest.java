package com.quest.test.thread.stringlock;

/**
 * Created by Quest on 2018/2/26.
 */
public class IpTreadTest {
    private static final int THREAD_COUNT = 5;
    public static void main(String[] args) {
        Thread[] threads = new Thread[THREAD_COUNT];
        for (int i = 0, len = threads.length; i < len; i++) {
            threads[i] = new Thread(new IpThread("192.168.1.1"));
        }
        for (int i = 0; i < THREAD_COUNT; i++) {
            threads[i].start();
        }
        while (true) {
            int n = 0;
            for (int i = 0,len = threads.length; i < len; i++) {
                if(threads[i].isAlive()){
                    break;
                }
                n++;
            }
            if(n == 5)break;
        }
    }
}
