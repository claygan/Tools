package com.quest.test;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.*;

public class JsonTest {
	@Test
	public void test(){
		String[] arr = {"a", "b", "c"};
		System.out.println(JSON.toJSONString(arr));

		List<String> list = new ArrayList<>();
		list.add("a");
		list.add("b");
		list.add("c");
		System.out.println(JSON.toJSONString(list));
		list.remove("b");
		System.out.println(JSON.toJSONString(list));
	}

}
