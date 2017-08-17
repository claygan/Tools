package com.quest.test;

import org.junit.Test;

import java.io.File;
import java.time.Clock;

public class StringTest {
	@Test
	public void test(){
//		String mobile = "13888888888";
//		System.out.println(mobile.substring(3, mobile.length() - 1));
//		System.out.println(mobile.substring(0, 3));
//		System.out.println(mobile.substring(mobile.length()-3, mobile.length()));
//		System.out.println(mobile.substring(0, 3)+"***"+mobile.substring(mobile.length()-1, mobile.length()));
//		System.out.println(mobile.replace(mobile.substring(3, mobile.length() - 1), "***"));
	}

	public static void main(String[] args) {
//		getString("a","b","c");
//		String a = System.getProperty("java.io.tmpdir");
//		System.out.println(a);
		System.out.println(Clock.systemDefaultZone().millis());
	}

	public static void getString(String... args) {
		for(String str : args){
			System.out.println(str);
		}
		System.out.println(args[0]);
		System.out.println(args[1]);
		System.out.println(args[2]);
	}
}
