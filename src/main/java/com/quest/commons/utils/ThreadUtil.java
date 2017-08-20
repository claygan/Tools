package com.quest.commons.utils;

import ch.qos.logback.core.net.SyslogOutputStream;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Title: ThreadUtil.java
 * @Package com.zzh.core.module.biz.utils
 * @Description: TODO(用一句话描述该文件做什么)
 * @author luog
 * @date 2013-12-3 下午4:33:24
 * @version V1.0
 */
public class ThreadUtil {

	private ThreadUtil() {

	}

	// 线程池核心线程数
	private static int CORE_POOL_SIZE = Runtime.getRuntime().availableProcessors() * 2;

	// 线程池最大线程数
	private static int MAX_POOL_SIZE = 100;

	// 额外线程空状态生存时间
	private static int KEEP_ALIVE_TIME = 10000;

	// 阻塞队列。当核心线程都被占用，且阻塞队列已满的情况下，才会开启额外线程。
	private static BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<Runnable>(10);

	// 线程工厂
	private static ThreadFactory threadFactory = new ThreadFactory() {
		private final AtomicInteger integer = new AtomicInteger();

		@Override
		public Thread newThread(Runnable r) {
			return new Thread(r, "myThreadPool thread:" + integer.getAndIncrement());
		}
	};

	// 线程池
	private static ThreadPoolExecutor threadPool;

	static {
		threadPool = new ThreadPoolExecutor(CORE_POOL_SIZE, MAX_POOL_SIZE, KEEP_ALIVE_TIME, TimeUnit.SECONDS, workQueue, threadFactory);
	}

	/**
	 * 从线程池中抽取线程，执行指定的Runnable对象
	 * 
	 * @param runnable
	 */
	public static void execute(Runnable runnable) {
		threadPool.execute(runnable);
	}
	
	/** 
	 * @Title: getNewThreadPoolExecutor 
	 * @Description: 获取新的线程池对象
	 * @return ThreadPoolExecutor
	 * @return 
	 */ 
	public static ThreadPoolExecutor getNewThreadPoolExecutor(){
		return new ThreadPoolExecutor(CORE_POOL_SIZE, MAX_POOL_SIZE, KEEP_ALIVE_TIME, TimeUnit.SECONDS, workQueue, threadFactory);
	}

	private static volatile  List<Integer> list = new ArrayList<>();
	public static void main(String[] args) {
		ThreadPoolExecutor executor = ThreadUtil.getNewThreadPoolExecutor();
		int len = 500;
		for (int i = 0; i < len; i++) {
			executor.execute(new Runnable() {
				@Override
				public void run() {
					Random r = new Random(10);
					list.add(r.nextInt());
					System.out.println(Thread.currentThread().getName()+": "+list.size());
				}
			});
			if(i == len-1)executor.shutdown();
		}
		while(true){
			if (executor.isTerminated()) {
				System.out.println("final:"+Thread.currentThread().getName()+": "+list.size());
				break;
			}

		}
	}

}
