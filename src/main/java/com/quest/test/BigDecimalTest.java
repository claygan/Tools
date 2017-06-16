package com.quest.test;

import java.math.BigDecimal;

import org.junit.Test;

/** 
 * @ClassName: BigDecimalTest
 * @Description: 其实java的float只能用来进行科学计算或工程计算，在大多数的商业计算中，一般采用java.math.BigDecimal类来进行精确计算。
				在使用BigDecimal类来进行计算的时候，主要分为以下步骤：
				1、用float或者double变量构建BigDecimal对象。
				2、通过调用BigDecimal的加，减，乘，除等相应的方法进行算术运算。
				3、把BigDecimal对象转换成float，double，int等类型。
 * 
 * @author ganshimin@zhongzhihui.com
 * @date: 2017年6月15日 下午3:23:10
 */  
public class BigDecimalTest {
	@Test
	public void test1(){
		System.out.println(0.01+0.09);//0.05、0.06、0.09
		System.out.println(1.0-0.42);
		System.out.println(4.015*100);
		System.out.println(303.1/1000);
		//构造方式
		BigDecimal b1 = new BigDecimal("0.06");
		BigDecimal b2 = new BigDecimal("0.01");
		System.out.println(b1.add(b2));
		System.out.println(b1.add(b2).doubleValue());//转换成基本类型
		//静态方法方式
		BigDecimal b3 = BigDecimal.valueOf(0.06);
		BigDecimal b4 = BigDecimal.valueOf(0.01);
		System.out.println(b3.add(b4));
		
	}
	
	@Test
	public void test2(){
		//int->byte
		//Java 中 int 是 32 位的，而 byte 是 8 位的，所以，如果强制转化是，int 类型的高 24 位将会被丢弃
		System.out.println((byte)127);//127
		System.out.println((byte)128);//-128
		System.out.println((byte)129);//-127
	}
	@Test
	public void test3(){
		//+= 隐式的将加操作的结果类型强制转换为持有结果的类型
		byte a = 127;
		byte b = 2;
//		a = a + b;//因为 a+b 操作会将 a、b 提升为 int 类型，所以将 int 类型赋值给 byte 就会编译出错
		a += b;//a = (byte)a+b;
		System.out.println(a);
		System.out.println(b);
	}
	@Test
	public void test4(){
//		int a = 1313;
//		
//		String _a = String.valueOf(a);
//		for (int i = 0; i < 4; i++) {
//			System.out.println(Integer.parseInt(""+_a.charAt(i)));
//		}
		System.out.println(4/8);
	}
}
