package com.quest.test;

import org.junit.Test;

public class FinallyTest {
	@SuppressWarnings("finally")
	@Test
	public void test() throws Exception{
		try {
			System.out.println("I'm in try!");
		}catch (Exception e) {
			System.out.println("I'm in catch!");
			e.printStackTrace();
		} finally {
			System.out.println("I'm in finally!");
			throw new Exception("I throw a exception!");
		}
	}
}
