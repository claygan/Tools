package com.quest.commons.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jhui on 2017/2/24.
 */
public class StringReplace {

    public static String replace(String templete,String[] param){
        if(param == null || param.length == 0){
            return templete;
        }
        int size = param.length;
        for(int i = 0; i < size; i++){
            int start = templete.indexOf("[");
            if(start == -1){
                return templete;
            }
            int end = templete.indexOf("]");
            String temp = templete.substring(start,end + 1);
            templete = templete.replace(temp,param[i]);
        }
        return templete;
    }
    public static String replaceZ_CH(String templete,String[] param){
        if(param == null || param.length == 0){
            return templete;
        }
        int size = param.length;
        for(int i = 0; i < size; i++){
            int start = templete.indexOf("【");
            if(start == -1){
                return templete;
            }
            int end = templete.indexOf("】");
            String temp = templete.substring(start,end + 1);
            templete = templete.replace(templete.substring(0,end+1),templete.substring(0,end+1).replace(temp,param[i]));
        }
        return templete;
    }
    public static String replace(String templete,Map<String, String> properties){
        if(properties == null || properties.isEmpty()){
            return templete;
        }
        for (Map.Entry<String, String> entry : properties.entrySet()){
            String key = entry.getKey();
            String value = entry.getValue();
            key = "[" + key + "]";
            templete = templete.replace(key,value);
        }
        return templete;
    }

    public static void main(String[] args) {
        Map<String, String> properties = new HashMap<>();
        properties.put("newDoctorName","王医生");
        properties.put("oldDoctorName","李医生");
        properties.put("patientName","张三");
        properties.put("chronicName","高血压");
        String result = replace("[patientName]的[chronicName]的主管医生由[oldDoctorName]变更为[newDoctorName]的申请未通过",properties);
        System.out.println(result);
    }
}
