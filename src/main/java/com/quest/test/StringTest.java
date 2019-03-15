package com.quest.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.util.StringUtil;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.quest.commons.utils.StringReplace;
import com.quest.entity.Record;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.converters.IntegerConverter;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.junit.Test;
import org.springframework.aop.support.AopUtils;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.time.Clock;
import java.util.*;

import static com.lowagie.text.Entities.map;
import static com.sun.tools.doclint.Entity.lang;

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

	@Test
	public void arr(){
		String[] sendFlags = { "2", "3"};
		String[] saveFlags = {"2", "3"};
		Set<String> resultSet = new HashSet<>(Arrays.asList(ArrayUtils.addAll(sendFlags,saveFlags)));
		System.out.println(resultSet);

	}
	@Test
	public void sub(){
		String atr = "hcn.patient.";
		System.out.println(getTenantId(atr));

	}

	public static String getTenantId(String productCode) {
		return productCode.substring(0, productCode.lastIndexOf("."));
	}

	@Test
	public void StringReplace() {
		String template = "aaaa【变量】aa,bbbbb【变量】bb";
		String[] param = new String[]{"3","4"};
		System.out.println(StringReplace.replaceZ_CH(template, param));
	}

	@Test
	public void instance(){
		Object anObject = 123;
		if (anObject instanceof String) {
			System.out.println((String)anObject);
		}else{
			System.out.println(anObject.getClass());
		}
	}
	@Test
	public void jsonParse(){
		String json = "{\"personName\":\"王玉婷\",\"consultServiceRecordId\":\"\",\"mpiId\":\"c9563b6e58e44cb291870c753aea6f31\",\"personHeader\":\"null\"}";
//		JSONObject obj = JSON.parseObject(json);
//		System.out.println(obj.getString("consultServiceRecordId"));
		JsonObject obj2 = (JsonObject) new JsonParser().parse(json);
		System.out.println(obj2.get("consultServiceRecordId")!=null);
		System.out.println(obj2.get("consultServiceRecordId").getAsString());
		System.out.println(StringUtils.isNotBlank(obj2.get("consultServiceRecordId").getAsString()));
	}
	@Test
	public void subStrings(){
		String productCode = "hcn.patient_ios";
		System.out.println(ProductUtil.getParentProductCode(productCode));
		System.out.println(ProductUtil.getParentProductCode(productCode));
	}

	@Test
	public void StringUtils(){
		String str = null;
		System.out.println("apache-lang:"+StringUtils.isNotBlank(str));
		System.out.println("apache-lang3:"+ org.apache.commons.lang3.StringUtils.isNotBlank(str));
		System.out.println("apache-cxf:"+ !org.apache.cxf.common.util.StringUtils.isEmpty(str));
		System.out.println("alibaba-druid:"+ !com.alibaba.druid.util.StringUtils.isEmpty(str));
		System.out.println("spring:"+ !org.springframework.util.StringUtils.isEmpty(str));
		System.out.println("ctrip-apollo:"+ !com.ctrip.framework.apollo.core.utils.StringUtils.isBlank(str));
		System.out.println("github-pagehelper:"+ StringUtil.isNotEmpty(str));
	}

	@Test
	public void parseInt(){
		Object obj = null;
//		System.out.println(Integer.parseInt(String.valueOf(obj)));
		System.out.println(NumberUtils.toInt(String.valueOf(obj), 0));
	}
	@Test
	public void chatAt(){
		String key = "Xds";
//		String json = "{\"birthday\":\"1948-03-26\",\"masterFlag\":\"y\",\"waterSourceCode\":\"1\",\"rhBloodCode\":\"1\",\"homePlace\":\"江苏省无锡市8100000000县璜土镇芦墩19组 村 璜土芦墩后栗村128号 号\",\"other\":{\"pastHiss\":{\"PastHis\":[{\"pastHisName\":\"上呼吸道感染\",\"pastHisTime\":\"2015-06-18\"},{\"pastHisName\":\"胃炎\",\"pastHisTime\":\"2015-03-20\"},{\"pastHisName\":\"感染\",\"pastHisTime\":\"2015-03-19\"},{\"pastHisName\":\"胃炎\",\"pastHisTime\":\"2015-03-16\"},{\"pastHisName\":\"胃炎\",\"pastHisTime\":\"2015-03-11\"},{\"pastHisName\":\"软组织挫伤\",\"pastHisTime\":\"2015-02-02\"},{\"pastHisName\":\"乏力\",\"pastHisTime\":\"2015-01-18\"},{\"pastHisName\":\"乏力\",\"pastHisTime\":\"2015-01-15\"},{\"pastHisName\":\"乏力\",\"pastHisTime\":\"2015-01-14\"},{\"pastHisName\":\"上呼吸道感染\",\"pastHisTime\":\"2015-01-13\"},{\"pastHisName\":\"乏力\",\"pastHisTime\":\"2015-01-12\"},{\"pastHisName\":\"上呼吸道感染\",\"pastHisTime\":\"2015-01-11\"},{\"pastHisName\":\"上呼吸道感染\",\"pastHisTime\":\"2015-01-05\"},{\"pastHisName\":\"上呼吸道感染\",\"pastHisTime\":\"2015-01-04\"},{\"pastHisName\":\"水肿\",\"pastHisTime\":\"2014-03-20\"}]},\"operationHistorys\":\"\",\"xds\":{\"Xds\":{\"code\":\"1\"}},\"fqs\":{\"Fqs\":{\"code\":\"2\"}},\"disabilityCodes\":\"\",\"riskFactorsTypeCodes\":{\"RiskFactorsTypeCode\":{\"code\":\"1\"}},\"drugAllergens\":{\"DrugAllergen\":{\"code\":\"1\"}},\"geneticDiseaseHistoryFlag\":\"1\",\"mqs\":{\"Mqs\":{\"code\":\"2\"}},\"zns\":{\"Zns\":{\"code\":\"1\"}},\"operationHistoryFlag\":\"1\"},\"deadFlag\":\"2\",\"idCard\":\"320219194803260273\",\"livestockColumn\":\"0\",\"educationCode\":\"3\",\"isHypertension\":\"y\",\"insuranceCode\":\"3\",\"maritalStatusCode\":\"2\",\"empiId\":\"32028181031410025543\",\"nationalityCode\":\"262\",\"workCode\":\"8\",\"contact\":\"季东\",\"manaUnitId\":\"46640426-9\",\"lastModifyDate\":\"2018-04-17\",\"workPlace\":\"无\",\"nationCode\":\"1\",\"registeredPermanent\":\"1\",\"address\":\"江苏省无锡市江阴市璜土镇芦墩村江阴璜土芦墩村19组128号号\",\"relaCode\":\"0\",\"phrId\":\"32028181031000375835\",\"washroom\":\"1\",\"personName\":\"季松云\",\"familyId\":\"32028181031000124619\",\"sexCode\":\"1\",\"phoneNumber\":\"13196515520\",\"fuelType\":\"1\",\"cookAirTool\":\"2\",\"createUser\":\"81031401\",\"bloodTypeCode\":\"5\",\"isDiabetes\":\"y\",\"contactPhone\":\"13196515520\",\"createUnit\":\"璜土社区卫生服务中心\",\"status\":\"01\"}";
		String json = "{\"birthday\":\"1948-03-26\",\"other\":{\"pastHiss\":{\"PastHis\":[{\"pastHisName\":\"上呼吸道感染\",\"pastHisTime\":\"2015-06-18\"},{\"pastHisName\":\"胃炎\",\"pastHisTime\":\"2015-03-20\"}]},\"xds\":{\"Xds\":{\"code\":\"1\"}},\"fqs\":{\"Fqs\":{\"code\":\"2\"}}},\"deadFlag\":\"2\"}";
		String data = "{\"" + key + "\":";
		int index = json.indexOf(data);
		if("[".equals(json.charAt(index+data.length())+"")){
			json = StringUtils.replace(json, data, "");
			int index2 = json.indexOf("]", index + 1);
			json = json.substring(0, index2 + 1) + json.substring(index2 + 2);
		}else{
			json = StringUtils.replace(json, data, "[");
			int index2 = json.indexOf("}", index + 1);
			json = json.substring(0, index2 + 1) +"]"+ json.substring(index2 + 2);
		}
		System.out.println(json);
	}
	@Test
	public void replace(){
		String t="asdf#{\"s\"}:sadf;kal#{}";
		System.out.println(t.indexOf("#{\"s\"}:"));
		String replace = StringUtils.replaceOnce(t,"#{\"s\"}:","<input>");
		System.out.println(replace);
	}
	@Test
	public void StringTokenizer(){
		StringTokenizer tokenizer = new StringTokenizer("as,ew,ds,ge");
		while (tokenizer.hasMoreTokens()) {
			System.out.println(tokenizer.nextToken(","));
		}
	}
	@Test
	public void format(){
		System.out.println(String.format("%.2f", 0.1));
	}

}
