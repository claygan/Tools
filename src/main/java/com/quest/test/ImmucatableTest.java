package com.quest.test;

import java.util.HashMap;

import com.quest.web.pojos.ImmucatableExample;

public class ImmucatableTest {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		int id = 10;
		String name = "origin";
		HashMap testMap = new HashMap();
		testMap.put("1", "first");
		testMap.put("2", "second");
		ImmucatableExample example = new ImmucatableExample(id, name, testMap);
		System.out.println(testMap == example.getTestMap());
		System.out.println(10 == example.getId());
		System.out.println("id:"+example.getId());
		System.out.println("name:"+example.getName());
		System.out.println("testMap:"+example.getTestMap());
		//test constructor
		id = 20;
		name = "modified";
		testMap.put("3", "third");
		System.out.println("after modified id:"+example.getId());
		System.out.println("after modified name:"+example.getName());
		System.out.println("after modified testMap:"+example.getTestMap());
		//test getTestMap
		HashMap newMap = example.getTestMap();
		newMap.put("4", "new");
		System.out.println("modified again testMap:"+example.getTestMap());
		
		
	}
}
