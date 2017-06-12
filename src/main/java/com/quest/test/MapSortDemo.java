package com.quest.test;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class MapSortDemo {
	public static void main(String[] args) {

//        Map<String, String> map = new TreeMap<String, String>();
//
//        map.put("KFC", "abf");
//        map.put("dNBA", "cda");
//        map.put("NBA", "sae");
//        map.put("CBA", "zsa");
//
//        List<Map.Entry<String,String>> resultList = sortMapByKey(map);  //按Key进行排序
//
//        for(Map.Entry<String,String> mapping:resultList){ 
//            System.out.println(mapping.getKey()+":"+mapping.getValue()); 
//       } 
		Calendar nowTime = Calendar.getInstance();
		nowTime.add(Calendar.MINUTE, 5);
		System.out.println(nowTime.getTimeInMillis());
        
    }

    /**
     * 使用 Map按key进行排序
     * @param map
     * @return
     */
    public static List<Map.Entry<String,String>> sortMapByKey(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        //将map.entrySet()转换成list
        List<Map.Entry<String,String>> list = new ArrayList<Map.Entry<String,String>>(map.entrySet());
        //然后通过比较器来实现排序
        Collections.sort(list,new Comparator<Map.Entry<String,String>>() {
            public int compare(Entry<String, String> o1, Entry<String, String> o2) {
                return o1.getKey().compareToIgnoreCase(o2.getKey());
            }
        });
        return list;
    }
    
    /** 
     * @Title: ascii2native
     * @Description: ASCII转native
     * @author ganshimin@zhongzhihui.com
     * @param ascii
     * @return  
     */  
    public static String ascii2native(String ascii) {  
        int n = ascii.length() / 6;  
        StringBuilder sb = new StringBuilder(n);  
        for (int i = 0, j = 2; i < n; i++, j += 6) {  
            String code = ascii.substring(j, j + 4);  
            char ch = (char) Integer.parseInt(code, 16);  
            sb.append(ch);  
        }  
        return sb.toString();  
    }  
    
}
