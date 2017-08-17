package com.quest.test;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import org.junit.*;

/** 
 * @ClassName: QueueTest
 * @Description: 
*异常
(>>)add        增加一个元索                     如果队列已满，则抛出一个IIIegaISlabEepeplian异常
(<-)remove   移除并返回队列头部的元素    如果队列为空，则抛出一个NoSuchElementException异常
(<<)element  返回队列头部的元素             如果队列为空，则抛出一个NoSuchElementException异常
*无异常
(>>)offer(提供)       添加一个元素并返回true       如果队列已满，则返回false
(<-)poll(轮询)         移除并返问队列头部的元素    如果队列为空，则返回null
(<<)peek(窥视)       返回队列头部的元素             如果队列为空，则返回null
*阻塞
(>>)put(放置)         添加一个元素                      如果队列满，则阻塞
(<-)take(拿)        移除并返回队列头部的元素     如果队列为空，则阻塞
 * 
 * @author ganshimin@zhongzhihui.com
 * @date: 2017年6月23日 下午3:06:30
 */  
public class QueueTest {
	/** 
	 * @Title: LinkedBlockingQueue（方便改动元素，访问相对较慢）
	 * @Description: 基于链表的队列，此队列按 FIFO（先进先出）排序元素
	 * @author ganshimin@zhongzhihui.com  
	 */  
	@Test
	public void LinkedBlockingQueue(){
		Queue<String> queue = new LinkedBlockingQueue<String>(3);
		queue.offer("a");
		queue.offer("b");
		queue.add("c");
		for (String string : queue) {
			System.out.println(string);
		}
		for (int i = 0; i <= 3; i++) {
//			System.out.println(queue.peek());
			System.out.println(queue.poll());
		}
	}
	/** 
	 * @Title: ArrayBlockingQueue（适合用于访问，不适合改动）
	 * @Description: 在构造时需要指定容量， 并可以选择是否需要公平性，如果公平参数被设置true，
	 * 等待时间最长的线程会优先得到处理（其实就是通过将ReentrantLock设置为true来 达到这种公平性的：
	 * 即等待时间最长的线程会先操作）。通常，公平性会使你在性能上付出代价，只有在的确非常需要的时候再使用它。
	 * 它是基于数组的“阻塞”循环队 列，此队列按 FIFO（先进先出）原则对元素进行排序。
	 * @author ganshimin@zhongzhihui.com  
	 */  
	@Test
	public void ArrayBlockingQueue(){
		Queue<String> queue = new ArrayBlockingQueue<String>(3);
		queue.offer("a");
		queue.offer("b");
		queue.add("c");
		for (String string : queue) {
			System.out.println(string);
		}
		for (int i = 0; i <= 3; i++) {
//			System.out.println(queue.peek());
			System.out.println(queue.poll());
		}
	}
	/** 
	 * @Title: PriorityBlockingQueue
	 * @Description: 是一个带优先级的 队列，而不是先进先出队列。
	 * 元素按优先级顺序被移除，该队列也没有上限（看了一下源码，PriorityBlockingQueue是对 PriorityQueue的再次包装，
	 * 是基于“堆数据结构”的，而PriorityQueue是没有容量限制的，与ArrayList一样，所以在优先阻塞 队列上put时是不会受阻的。
	 * 虽然此队列逻辑上是无界的，但是由于资源被耗尽，所以试图执行添加操作可能会导致 OutOfMemoryError），
	 * 但是如果队列为空，那么取元素的操作take就会阻塞，所以它的检索操作take是受阻的。
	 * 另外，往入该队列中的元 素要具有比较能力。
	 * @author ganshimin@zhongzhihui.com  
	 */  
	@Test
	public void PriorityBlockingQueue(){
		Queue<String> queue = new PriorityBlockingQueue<String>(3);
		queue.offer("a");
		queue.offer("b");
		queue.add("c");
		for (String string : queue) {
			System.out.println(string);
		}
		for (int i = 0; i <= 3; i++) {
//			System.out.println(queue.peek());
			System.out.println(queue.poll());
		}
	}
	/** 
	 * @Title: DelayQueue
	 * @Description: （基于PriorityQueue来实现的）是一个存放Delayed 元素的无界阻塞队列，
	 * 只有在延迟期满时才能从中提取元素。该队列的头部是延迟期满后保存时间最长的 Delayed 元素。
	 * 如果延迟都还没有期满，则队列没有头部，并且poll将返回null。
	 * 当一个元素的 getDelay(TimeUnit.NANOSECONDS) 方法返回一个小于或等于零的值时，则出现期满，poll就以移除这个元素了。
	 * 此队列不允许使用 null 元素
	 * @author ganshimin@zhongzhihui.com  
	 */  
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void DelayQueue(){
		Queue<String> queue = new DelayQueue();
		queue.offer("a");
		queue.offer("b");
		queue.add("c");
		for (String string : queue) {
			System.out.println(string);
		}
		for (int i = 0; i <= 3; i++) {
//			System.out.println(queue.peek());
			System.out.println(queue.poll());
		}
	}
}
