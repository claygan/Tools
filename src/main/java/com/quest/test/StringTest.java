package com.quest.test;

import com.quest.entity.Record;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.time.Clock;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

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
		String atr = ",123";
		String[] arr = atr.split(",");
		System.out.println(Arrays.toString(arr));
		System.out.println(arr.length);
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
	@Test
	public void valueofTest(){
		HashMap map = new HashMap();
		System.out.println((map.get("a")));
		System.out.println(String.valueOf(map.get("a")));
	}

	@Test
	public void subfix(){
		String fileName= "aaaa.docx";
		String prefix=fileName.substring(fileName.lastIndexOf(".")+1);
		System.out.println(prefix);
	}
	@Test
	public void lowerCase(){
		String str= "IOS_1.0.1";
		System.out.println(str.toLowerCase());
		System.out.println(str.toLowerCase(Locale.CHINESE));
		System.out.println(str.toLowerCase(Locale.ENGLISH));
	}
	@Test
	public void subString(){
		String str = "/admin/mdc/doc/";
		System.out.println(StringUtils.chop(str));//去掉最后一个字符
		String s2 = "//admin/mdc/doc////";
		System.out.println(StringUtils.strip(s2,"/"));//截取两边连续的字符
	}

	@Test
	public void spilt(){
		String str = "510000000000|510600000000|510681000000|510681102000";
		String[] parents = str.split("\\|");
		System.out.println(Arrays.toString(parents));
		/*
			关于点的问题是用string.split("[.]") 解决。
			关于竖线的问题用 string.split("\\|")解决。
			关于星号的问题用 string.split("\\*")解决。
			关于斜线的问题用 sring.split("\\\\")解决。
			关于中括号的问题用 sring.split("\\[\\]")解决。
		*/
	}
	@Test
	public void subString2(){
		String str = "fasfaasdfasfa";
		System.out.println(str.substring(0,20)+"...");
	}
	@Test
	public void spilt2(){
		String str = "2018-01";
		String[] result = str.split("-");
		System.out.println(result[0]);
		if (result.length > 1) {
			System.out.println(result[1]);
		}
	}
	@Test
	public void sub3(){
		String str = "hcn.tongxiang.patient";
		System.out.println(str.substring(0,str.lastIndexOf(".")));
	}

}
