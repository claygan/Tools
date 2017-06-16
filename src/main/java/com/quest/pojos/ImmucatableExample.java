package com.quest.pojos;

import java.util.HashMap;
import java.util.Iterator;

public final class ImmucatableExample {
	private final int id;
	private final String name;
	@SuppressWarnings("rawtypes")
	private final HashMap testMap;
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	@SuppressWarnings("rawtypes")
	public HashMap getTestMap() {
		return testMap;
//		return (HashMap)testMap.clone();
	}
	
	/**
	 * 实现浅拷贝（shallow copy）的构造器
	 *
	 * @param id
	 * @param name
	 * @param testMap
	 */
	@SuppressWarnings("rawtypes")
	public ImmucatableExample(int id, String name, HashMap testMap) {
		System.out.println("Performing Shallow Copy for Object initialization");
		this.id = id;
		this.name = name;
		this.testMap = testMap;
	}
	
	/**
	 * 实现深拷贝(deep copy)的构造器
	 *
	 * @param id
	 * @param name
	 * @param testMap
	 */
//	@SuppressWarnings({ "unchecked", "rawtypes" })
//	public ImmucatableExample(int id,String name, HashMap testMap){
//		System.out.println("Performing Deep Copy for Object initialization");
//		this.id = id;
//		this.name = name;
//		HashMap tempMap = new HashMap();
//		String key;
//		Iterator it = testMap.keySet().iterator();
//		while(it.hasNext()){
//			key = (String)it.next();
//			tempMap.put(key, testMap.get(key));
//		}
//		this.testMap = tempMap;
//	}
	
}
