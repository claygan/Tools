package com.quest.test.concurrent;

import com.quest.test.concurrent.pojos.DelayedElement;
import com.quest.test.concurrent.pojos.PriorityElement;
import com.quest.test.concurrent.pojos.Student;
import org.junit.Test;

import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by Quest on 2017/8/25.
 */
public class BlockingQueueTest {
    @Test
    public void test(){
        try {
            DelayQueue<DelayedElement> queue= new DelayQueue<>();
            DelayedElement ele= new DelayedElement( "cache 3 seconds",3000);
            queue.put(ele);
            System. out.println(queue.take());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    /**
     *@Description: 学生交卷问题，先做完先交卷
     * 每个学生在指定开始时间到达之后就会“交卷”（取决于getDelay()方法），并且是先做完的先交卷（取决于compareTo()方法）
     */
    @Test
    public void DelayQueueTest(){
        int STUDENT_SIZE = 30;
        Random r = new Random();
        //把所有学生看做一个延迟队列
        DelayQueue<Student> students = new DelayQueue<Student>();
        //构造一个线程池用来让学生们“做作业”
        ExecutorService exec = Executors.newFixedThreadPool(STUDENT_SIZE);
        for ( int i = 0; i < STUDENT_SIZE; i++) {
            //初始化学生的姓名和做题时间
            students.put( new Student( "学生" + (i + 1), 3000 + r.nextInt(10000)));
        }
        //开始做题
        try {
            while(! students.isEmpty()){
                exec.execute( students.take());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            exec.shutdown();
        }
    }
    /**
     *@Description: 优先级
     */
    @Test
    public void PriorityBlockingQueueTest() throws InterruptedException {
        PriorityBlockingQueue<PriorityElement> queue = new PriorityBlockingQueue<>();
        for (int i = 0; i < 10; i++) {
            Random r = new Random();
            PriorityElement element = new PriorityElement(r.nextInt(10));
            queue.put(element);
        }
        while (!queue.isEmpty()) {
            System.out.println(queue.take());
        }
    }

    /**
     *@Description: 只能放一个元素，线程阻塞
     */
    @Test
    public void SynchronousQueueTest() throws InterruptedException {
        SynchronousQueue<String> queue = new SynchronousQueue<>();
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(Thread.currentThread().getName()+" put one");
                        queue.put(Thread.currentThread().getName());
                        Thread.currentThread().sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        executorService.shutdown();
        System.out.println("take:"+queue.take());
        int count = 0;
//        while (count < 10) {
//            while (!queue.isEmpty()){
//                count ++;
//                System.out.println(queue.take());
//            }
//        }

    }
}
