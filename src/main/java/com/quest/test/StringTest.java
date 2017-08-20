package com.quest.test;

import org.junit.Test;

public class StringTest {
	@Test
	public void test(){
		String mobile = "13888888888";
		System.out.println(mobile.substring(3, mobile.length() - 1));
		System.out.println(mobile.substring(0, 3));
		System.out.println(mobile.substring(mobile.length()-3, mobile.length()));
		System.out.println(mobile.substring(0, 3)+"***"+mobile.substring(mobile.length()-1, mobile.length()));
//		System.out.println(mobile.replace(mobile.substring(3, mobile.length() - 1), "***"));
		
	}
}
