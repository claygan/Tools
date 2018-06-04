package com.quest.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
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

	@Test
	public void test1(){
		String data = "{\"userid\":\"1523416942000001212\",\"openid\":\"oB0Rbw6Z55PtVHg3OtOCE1hFr8-4\",\"cloudUserBean\":{\"id\":\"161880\",\"userId\":\"50f3495e-966e-4e2d-a7b3-4966286133eb\",\"mpiId\":\"366c66e154284a89b2b15c8721307cbb\",\"accessToken\":\"ad609b85-8b5c-4f3b-a810-f204671d816c\",\"userName\":\"库日天\",\"loginName\":\"18969817003\",\"tenantId\":\"hcn\",\"manageUnit\":\"hcn\",\"roleId\":\"patient\"}}";
		Map<String, Object> map = JSON.parseObject(data, new TypeReference<HashMap<String, Object>>(){});
		System.out.println(map);
		System.out.println(JSON.toJSONString(map));
	}

}
