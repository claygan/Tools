package com.quest.test.concurrent;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Quest on 2017/8/25.
 * 旅行团案例
 */
public class TestCyclicBarrier {
    //徒步需要的时间: Shenzhen, Guangzhou, Shaoguan, Changsha, Wuhan
    private static  int[] timeWalk = {5,8,13,15,12};
    //自驾游
    private static  int[] timeSelf= {1,3,4,5,4};
    //旅游大巴
    private static  int[] timeBus = {2,4,6,7,6};
    static String now(){
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        return sdf.format(new Date());
    }
    static class Tour implements Runnable{
        private int[] times;
        private CyclicBarrier barrier;
        private String tourName;

        public Tour(int[] times, CyclicBarrier barrier, String tourName) {
            this.times = times;
            this.barrier = barrier;
            this.tourName = tourName;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(times[0]* 1000);
                System.out.println(now()+" "+ tourName + " Reached Shenzhen");
                barrier.await();
                Thread.sleep(times[1]* 1000);
                System.out.println(now()+" "+ tourName + " Reached Guangzhou");
                barrier.await();
                Thread.sleep(times[2]* 1000);
                System.out.println(now()+" "+ tourName + " Reached Shaoguan");
                barrier.await();
                Thread.sleep(times[3]* 1000);
                System.out.println(now()+" "+ tourName + " Reached Changsha");
                barrier.await();
                Thread.sleep(times[4]* 1000);
                System.out.println(now()+" "+ tourName + " Reached Wuhan");
                barrier.await();

            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        //三个旅行团
        CyclicBarrier barrier = new CyclicBarrier(3);
        ExecutorService service = Executors.newFixedThreadPool(3);
        service.submit(new Tour(timeWalk, barrier, "WalkTour"));
        service.submit(new Tour(timeSelf, barrier, "SelfTour"));
        //当我们把下面的这段代码注释后，会发现，程序阻塞了，无法继续运行下去。
//        service.submit(new Tour(timeBus, barrier, "BusTour"));
        service.shutdown();

    }

}
