package com.quest.test.algorithm;

import org.apache.commons.collections.CollectionUtils;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MostCharTest {
    public static void main(String[] args) {
        String[] arr = {"b", "b", "a", "c", "a", "b", "a", "a","b"};
        //找出第一次出现次数最多的字符
        Map<String, Integer> map = new HashMap<>();
        for (String a : arr) {
            if (map.containsKey(a)) {
                map.put(a, map.get(a) + 1);
            }else{
                map.put(a, 1);
            }
        }
        String key = null;
        int num = 0;
        for (Map.Entry<String,Integer> m : map.entrySet()) {
            if(key == null || num < m.getValue()){
                key = m.getKey();
                num = m.getValue();
            }
        }
        System.out.println(key);
    }
}
