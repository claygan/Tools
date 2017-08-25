package com.quest.test.concurrent.pojos;

import java.util.Random;
import java.util.concurrent.Callable;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;

/**
 * Created by Quest on 2017/8/25.
 */
public class MyCompletionService implements Callable {
    private int id;
    public MyCompletionService(int id){
        this.id = id;
    }
    @Override
    public Object call() throws Exception {
        Integer time = (int) (Math.random() * 1000);
        System.out.println(this.id + " start");
        Thread.sleep(time);
        System.out.println(this.id+" end");
        return this.id + " : " + time;
    }
}
