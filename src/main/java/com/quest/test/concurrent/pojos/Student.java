package com.quest.test.concurrent.pojos;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * Created by Quest on 2017/8/25.
 */
public class Student implements Runnable,Delayed {
    private String name;  //姓名
    private long costTime;//做试题的时间
    private long finishedTime;//完成时间

    public Student(String name, long costTime) {
        this. name = name;
        this. costTime= costTime;
        finishedTime = costTime + System. currentTimeMillis();
    }

    @Override
    public void run() {
        System.out.println(name + " 交卷,用时" + costTime / 1000 + "." + costTime % 1000 + "s");
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return ( finishedTime - System. currentTimeMillis());
    }

    @Override
    public int compareTo(Delayed o) {
        Student other = (Student) o;
        return costTime >= other. costTime?1:-1;
    }
}
