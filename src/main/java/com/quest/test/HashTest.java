package com.quest.test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

import org.junit.Test;

public class HashTest {
	@Test
	public void test(){
		String a = "abc";
		System.out.println(a.hashCode());
		String b = new String("abc");
		System.out.println(b.hashCode());
		System.out.println(a==b);
		Map<String, Object> map = new HashMap<String, Object>();
		
	}
	
	@Test
	public void test2(){
		HashSet map = new HashSet();
	}
	
	@Test
	public void test3(){
		Entry[] table = new Entry[16];
		table[1].setValue("a"); 
	}
	@Test
	public void test4(){
		ConcurrentHashMap<String , Object> cmap = new ConcurrentHashMap<String, Object>();
		cmap.put("a", "A");
		cmap.put("b", "B");
		HashMap map = new HashMap();
		
	}
}
