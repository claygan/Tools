package com.quest.test.thread.stringlock;

/**
 * Created by Quest on 2018/2/26.
 */
public class IpThread implements Runnable{
    private static final String LOCK_PRIFIX = "IP--";
    private String ip;

    public IpThread(String ip) {
        this.ip = ip;
    }

    @Override
    public void run() {
        String lock = geraterIp();
        synchronized (lock) {
            System.out.println("[" + Thread.currentThread().getName() + "]-开始运行~");
            try {
                Thread.sleep(5000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("[" + Thread.currentThread().getName() + "]-结束运行~");
        }
    }

    private String geraterIp(){
        StringBuilder ipString = new StringBuilder();
        ipString.append(LOCK_PRIFIX);
        ipString.append(ip);
        System.out.println("[" + Thread.currentThread().getName() + "]-构造了->"+ipString.toString());
        //
        return ipString.toString().intern();
    }
}
