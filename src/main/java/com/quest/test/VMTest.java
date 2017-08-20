package com.quest.test;

import org.junit.Test;

public class VMTest {

	@Test
	public void test(){
		Runtime runtime = Runtime.getRuntime();
		System.out.println("total:"+runtime.totalMemory());
		System.out.println("max:"+runtime.maxMemory());
		System.out.println("free:"+runtime.freeMemory());
		System.out.println();
	}
   
}
