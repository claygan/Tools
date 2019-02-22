package com.quest.test.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.google.common.collect.Lists;
import com.quest.commons.utils.FileUtil;
import com.quest.test.beanUtils.PojoUtil;
import com.quest.test.json.beans.UserInfo;
import com.quest.test.json.beans.visit.CtsArchiveDetailResponse;
import com.quest.test.json.tools.FastJsonUtil;
import com.quest.test.json.tools.JsonConvertUtil;
import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.aspectj.weaver.tools.cache.SimpleCacheFactory.path;

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
	@Test
	public void jsonObject(){
		String xml = "200";
		System.out.println();
	}

	@Test
	public void toObj() throws Exception {
        List<UserInfo> userList = Lists.newArrayList();
        userList.add(buildUser());
        userList.add(buildUser());

        String s = JSON.toJSONString(userList);
        System.out.println(s);
//        UserInfo result = JsonConvertUtil.resultSet(new Class[]{UserInfo.class}, buildData(user));
//        UserInfo result = FastJsonUtil.parseJsonToObj(s, UserInfo.class);
        List<UserInfo> result = (List<UserInfo>)JSONArray.parseArray(s, UserInfo.class);
        System.out.println(JSON.toJSONString(result));

    }
    private UserInfo buildUser(){
        UserInfo user = new UserInfo();
        user.setName("curry");
        user.setAge(30);
        user.setJob("player");
        UserInfo.Parent parent = new UserInfo.Parent();
        UserInfo.Company company = new UserInfo.Company();
        company.setCname("nba");
        company.setCode("111");
        UserInfo.Company company2 = new UserInfo.Company();
        company2.setCname("cba");
        company2.setCode("222");
        List<UserInfo.Company> companyList = Lists.newArrayList();
        companyList.add(company);
        companyList.add(company2);
        parent.setFather("daier");
        parent.setMonth("silina");
        parent.setCompanyList(companyList);
        user.setParent(parent);
        return user;
    }


    private String buildData(Object obj){
        JSONObject json = new JSONObject();
        json.put("code" , 200);
        json.put("msg" , "hello");
        json.put("body" , obj );
        return JSON.toJSONString(json);
    }

    @Test
    public void json2Obj() throws Exception {
//        String json = "{\"pageNo\":\"1\",\"pageSize\":\"10\",\"totalCount\":\"13\",\"body\":{\"PersonVO\":[{\"birthday\":\"1956-11-13\",\"personName\":\"高国建\",\"empiId\":\"32028181031410011224\",\"sexCode\":\"1\",\"regionCode\":\"46640426-9\",\"idCard\":\"320219195611130276\",\"mobileNumber\":\"13701525281\",\"plan\":{\"VisitPlan\":{\"recordId\":\"32028181031000375873\",\"businessType\":\"1\",\"planDate\":\"2018-08-08\"}},\"age\":\"62\"},{\"birthday\":\"1948-03-26\",\"personName\":\"季松云\",\"empiId\":\"32028181031410025543\",\"sexCode\":\"1\",\"regionCode\":\"46640426-9\",\"idCard\":\"320219194803260273\",\"mobileNumber\":\"13196515520\",\"plan\":{\"VisitPlan\":{\"recordId\":\"32028181031000375835\",\"businessType\":\"1\",\"planDate\":\"2018-08-07\"}},\"age\":\"70\"},{\"birthday\":\"1927-01-14\",\"personName\":\"张桂娣\",\"empiId\":\"32028181031410023200\",\"sexCode\":\"2\",\"regionCode\":\"46640426-9\",\"idCard\":\"320219192701140263\",\"mobileNumber\":\"86662379\",\"plan\":{\"VisitPlan\":{\"recordId\":\"32028181031000375830\",\"businessType\":\"1\",\"planDate\":\"2018-08-07\"}},\"age\":\"91\"},{\"birthday\":\"1928-07-23\",\"personName\":\"季荣兆\",\"empiId\":\"32028181031410024520\",\"sexCode\":\"1\",\"regionCode\":\"46640426-9\",\"idCard\":\"320219192807230291\",\"mobileNumber\":\"86662379\",\"plan\":{\"VisitPlan\":{\"recordId\":\"32028181031000375829\",\"businessType\":\"1\",\"planDate\":\"2018-08-07\"}},\"age\":\"90\"},{\"birthday\":\"1935-09-26\",\"personName\":\"徐巧英\",\"empiId\":\"32028181031410024530\",\"sexCode\":\"2\",\"regionCode\":\"46640426-9\",\"idCard\":\"32021919350926026X\",\"mobileNumber\":\"13701525281\",\"plan\":{\"VisitPlan\":{\"recordId\":\"32028181031000375877\",\"businessType\":\"1\",\"planDate\":\"2018-08-07\"}},\"age\":\"83\"},{\"birthday\":\"1937-05-24\",\"personName\":\"韩甫妹\",\"empiId\":\"32028181031410012920\",\"sexCode\":\"2\",\"regionCode\":\"46640426-9\",\"idCard\":\"320219193705240266\",\"mobileNumber\":\"86662318\",\"plan\":{\"VisitPlan\":{\"recordId\":\"32028181031000375602\",\"businessType\":\"1\",\"planDate\":\"2018-08-07\"}},\"age\":\"81\"},{\"birthday\":\"1944-05-22\",\"personName\":\"刘仁法\",\"empiId\":\"32028181031410025415\",\"sexCode\":\"1\",\"regionCode\":\"46640426-9\",\"idCard\":\"320219194405220276\",\"mobileNumber\":\"13621532390\",\"plan\":{\"VisitPlan\":{\"recordId\":\"32028181031000376483\",\"businessType\":\"1\",\"planDate\":\"2018-08-08\"}},\"age\":\"74\"},{\"birthday\":\"1931-04-27\",\"personName\":\"高生伯\",\"empiId\":\"32028181031410024536\",\"sexCode\":\"1\",\"regionCode\":\"46640426-9\",\"idCard\":\"320219193104270275\",\"mobileNumber\":\"13701525281\",\"plan\":{\"VisitPlan\":{\"recordId\":\"32028181031000375876\",\"businessType\":\"1\",\"planDate\":\"2018-08-07\"}},\"age\":\"87\"},{\"birthday\":\"1942-01-29\",\"personName\":\"杭秀英\",\"empiId\":\"32028181031410012886\",\"sexCode\":\"2\",\"regionCode\":\"46640426-9\",\"idCard\":\"320219194201290264\",\"mobileNumber\":\"86662371\",\"plan\":{\"VisitPlan\":{\"recordId\":\"32028181031000375812\",\"businessType\":\"1\",\"planDate\":\"2018-08-07\"}},\"age\":\"76\"},{\"birthday\":\"1935-11-13\",\"personName\":\"陈秀珍\",\"empiId\":\"32028181031410025398\",\"sexCode\":\"2\",\"regionCode\":\"46640426-9\",\"idCard\":\"320219193511130261\",\"mobileNumber\":\"86666892\",\"plan\":{\"VisitPlan\":{\"recordId\":\"32028181031000376363\",\"businessType\":\"1\",\"planDate\":\"2018-08-08\"}},\"age\":\"83\"}]}}";
//        CtsVisitPlansResponse response = FastJsonUtil.parseJsonToObj(json, CtsVisitPlansResponse.class);
//        String json = "{\"birthday\":\"1948-03-26\",\"masterFlag\":\"y\",\"waterSourceCode\":\"1\",\"rhBloodCode\":\"1\",\"homePlace\":\"江苏省无锡市8100000000县璜土镇芦墩19组 村 璜土芦墩后栗村128号 号\",\"other\":{\"pastHiss\":{\"PastHis\":[{\"pastHisName\":\"上呼吸道感染\",\"pastHisTime\":\"2015-06-18\"},{\"pastHisName\":\"胃炎\",\"pastHisTime\":\"2015-03-20\"},{\"pastHisName\":\"感染\",\"pastHisTime\":\"2015-03-19\"},{\"pastHisName\":\"胃炎\",\"pastHisTime\":\"2015-03-16\"},{\"pastHisName\":\"胃炎\",\"pastHisTime\":\"2015-03-11\"},{\"pastHisName\":\"软组织挫伤\",\"pastHisTime\":\"2015-02-02\"},{\"pastHisName\":\"乏力\",\"pastHisTime\":\"2015-01-18\"},{\"pastHisName\":\"乏力\",\"pastHisTime\":\"2015-01-15\"},{\"pastHisName\":\"乏力\",\"pastHisTime\":\"2015-01-14\"},{\"pastHisName\":\"上呼吸道感染\",\"pastHisTime\":\"2015-01-13\"},{\"pastHisName\":\"乏力\",\"pastHisTime\":\"2015-01-12\"},{\"pastHisName\":\"上呼吸道感染\",\"pastHisTime\":\"2015-01-11\"},{\"pastHisName\":\"上呼吸道感染\",\"pastHisTime\":\"2015-01-05\"},{\"pastHisName\":\"上呼吸道感染\",\"pastHisTime\":\"2015-01-04\"},{\"pastHisName\":\"水肿\",\"pastHisTime\":\"2014-03-20\"}]},\"operationHistorys\":\"\",\"xds\":{\"Xds\":{\"code\":\"1\"}},\"fqs\":{\"Fqs\":{\"code\":\"2\"}},\"disabilityCodes\":\"\",\"riskFactorsTypeCodes\":{\"RiskFactorsTypeCode\":{\"code\":\"1\"}},\"drugAllergens\":{\"DrugAllergen\":{\"code\":\"1\"}},\"geneticDiseaseHistoryFlag\":\"1\",\"mqs\":{\"Mqs\":{\"code\":\"2\"}},\"zns\":{\"Zns\":{\"code\":\"1\"}},\"operationHistoryFlag\":\"1\"},\"deadFlag\":\"2\",\"idCard\":\"320219194803260273\",\"livestockColumn\":\"0\",\"educationCode\":\"3\",\"isHypertension\":\"y\",\"insuranceCode\":\"3\",\"maritalStatusCode\":\"2\",\"empiId\":\"32028181031410025543\",\"nationalityCode\":\"262\",\"workCode\":\"8\",\"contact\":\"季东\",\"manaUnitId\":\"46640426-9\",\"lastModifyDate\":\"2018-04-17\",\"workPlace\":\"无\",\"nationCode\":\"1\",\"registeredPermanent\":\"1\",\"address\":\"江苏省无锡市江阴市璜土镇芦墩村江阴璜土芦墩村19组128号号\",\"relaCode\":\"0\",\"phrId\":\"32028181031000375835\",\"washroom\":\"1\",\"personName\":\"季松云\",\"familyId\":\"32028181031000124619\",\"sexCode\":\"1\",\"phoneNumber\":\"13196515520\",\"fuelType\":\"1\",\"cookAirTool\":\"2\",\"createUser\":\"81031401\",\"bloodTypeCode\":\"5\",\"isDiabetes\":\"y\",\"contactPhone\":\"13196515520\",\"createUnit\":\"璜土社区卫生服务中心\",\"status\":\"01\"}";
        Path path = Paths.get("F:\\Desktop\\d.json");
        String json = FileUtil.readContent(path);
        System.out.println(JSON.toJSONString(JSONObject.parseObject(json)));
//        CtsArchiveDetailResponse response = PojoUtil.convert(JSONObject.parseObject(json), CtsArchiveDetailResponse.class);
//        CtsArchiveDetailResponse response = FastJsonUtil.parseJsonToObj(json, CtsArchiveDetailResponse.class);
//        CtsArchiveDetailResponse response = JsonConvertUtil.resultSet(new Class[]{CtsArchiveDetailResponse.class}, buildData(JSON.parseObject(json)));
//        System.out.println(JSON.toJSONString(response));
    }


}
