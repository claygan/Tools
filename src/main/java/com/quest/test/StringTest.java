package com.quest.test;

import com.quest.entity.Record;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.time.Clock;
import java.util.Date;

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
//		System.out.println(Clock.systemDefaultZone().millis());
	}

	public static void getString(String... args) {
		for(String str : args){
			System.out.println(str);
		}
		System.out.println(args[0]);
		System.out.println(args[1]);
		System.out.println(args[2]);
	}

	/**
	 *@Description: String.format 作为文本处理工具，为我们提供强大而丰富的字符串格式化功能
	 */
	@Test
	public void stringFormatTest(){
		//占位符格式为： %[index$][标识]*[最小宽度][.精度]转换符
		/*
		*  -，在最小宽度内左对齐,不可以与0标识一起使用。
		  0，若内容长度不足最小宽度，则在左边用0来填充。
		  #，对8进制和16进制，8进制前添加一个0,16进制前添加0x。
		  +，结果总包含一个+或-号。
		  空格，正数前加空格，负数前加-号。
		  ,，只用与十进制，每3位数字间用,分隔。
		  (，若结果为负数，则用括号括住，且不显示符号。
		可用转换符：
		  b，布尔类型，只要实参为非false的布尔类型，均格式化为字符串true，否则为字符串false。
		  n，平台独立的换行符, 也可通过System.getProperty("line.separator")获取。
		  f，浮点数型（十进制）。显示9位有效数字，且会进行四舍五入。如99.99。
		  a，浮点数型（十六进制）。
		  e，指数类型。如9.38e+5。
		  g，浮点数型（比%f，%a长度短些，显示6位有效数字，且会进行四舍五入）
		* */
		double num = 123.4567899;
		System.out.print(String.format("%f %n", num)); // 123.456790
		System.out.print(String.format("%a %n", num)); // 0x1.edd3c0bb46929p6
		System.out.print(String.format("%g %n", num)); // 123.457
	}
}
