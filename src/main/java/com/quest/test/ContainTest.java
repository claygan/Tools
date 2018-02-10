package com.quest.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Quest on 2017/12/11.
 */
public class ContainTest {
    @Test
    public void list(){
        long start = System.currentTimeMillis();
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        System.out.println(list.contains("3"));
        long end = System.currentTimeMillis();
        System.out.println("==========>耗时：" + (end - start));
    }
    @Test
    public void map(){
        long start = System.currentTimeMillis();
        HashMap map = new HashMap();
        map.put("1", "");
        map.put("2", "");
        map.put("3", "");
        System.out.println(map.containsKey("3"));
        long end = System.currentTimeMillis();
        System.out.println("==========>耗时：" + (end - start));
    }
    @Test
    public void arr(){
        long start = System.currentTimeMillis();
        String[] arr = new String[]{"1","2","3"};
        System.out.println(arrContainKey(arr, "3"));
        long end = System.currentTimeMillis();
        System.out.println("==========>耗时：" + (end - start));
    }
    private boolean arrContainKey(String[] arr,String key){
        for (int i = 0, len = arr.length; i < len; i++) {
            if (key.equals(arr[i])) {
                return true;
            }
        }
        return false;
    }
}
