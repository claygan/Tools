package com.quest.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by Gansm on 2017-08-14 0014.
 */
public class ThreadTest {
    public static void main(String[] args) {
        ExecutorService objExecutorService = Executors.newFixedThreadPool(3);
        CompletionService<String> objCompletionService = new ExecutorCompletionService<String>(
                objExecutorService);
        List<String> list = new ArrayList<>();
        for(int i= 0;i<5000;i++){

            final int iResult = i;
            objCompletionService.submit(new Callable<String>() {

                public String call() throws Exception {
                    list.add("a");
                    return Thread.currentThread().getName()+":size:"+list.size();
                }

            });
        }
        for (int i = 0; i < 5000; i++) {
            try {
                System.out.println(objCompletionService.take().get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        System.out.println("final size:"+list.size());
        objExecutorService.shutdownNow();
    }

}
