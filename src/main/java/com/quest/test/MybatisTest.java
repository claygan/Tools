package com.quest.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.quest.entity.Department;
import com.quest.service.DepartmentService;

@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类  
@ContextConfiguration(locations = {"classpath*:spring-mybatis.xml"})
public class MybatisTest {
	@Resource
	private DepartmentService departmentService;
	@Test
	public void test(){
		System.out.println("1");
		Department department = departmentService.findDepartmentById(11);
		System.out.println("2");
		System.out.println(department.getDeptName());
		System.out.println("3");
	}
}
