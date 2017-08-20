package com.quest.test;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListDeleteTest {
	public static void main(String[] args)
	{
		ArrayList<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("b");
		list.add("c");
		list.add("c");
		list.add("c");
		remove3(list);
 
		for (String s : list) 
		{
			System.out.println("element : " + s);
		}
	}
	/** 
	 * @Description:这种最普通的循环写法执行后会发现第二个“b”的字符串没有删掉。
	 * 因为执行System.arraycopy方法，导致删除元素时涉及到数组元素的移动。
	 * 可以用“倒序方式”来完成删除
	 */  
	public static void remove1(ArrayList<String> list) 
	{
		for (int i = 0; i < list.size(); i++) {
			String a = list.get(i);
			if("b".equals(a)){
				list.remove(i);
			}
		}
	}
	/** 
	 * @Description: 这种for-each写法会报出著名的并发修改异常：java.util.ConcurrentModificationException
	 * 原因是foreach写法是对实际的Iterable、hasNext、next方法的简写，remove(Object)方法修改了modCount的值
	 * 
	 */  
	public static void remove2(ArrayList<String> list) 
	{
		for (String s : list){
			if (s.equals("b")){
				list.remove(s);
			}
		}
	}
	/** 
	 * @Description:不要使用ArrayList的remove，改为用Iterator的remove即可
	 */  
	public static void remove3(ArrayList<String> list) 
	{
		Iterator<String> it = list.iterator();
		while (it.hasNext()) {
			String s = it.next();
			if (s.equals("b")){
				it.remove();
			}
		}
	}
}
