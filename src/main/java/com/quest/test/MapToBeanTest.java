package com.quest.test;

import com.quest.entity.Department;
import com.quest.entity.Record;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.map.HashedMap;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.Map;

/**
 * Created by Quest on 2017/8/25.
 */
public class MapToBeanTest {
    @Test
    public void test(){
        Map<String, Object> map = new HashedMap();
        map.put("deptName", "as");
        try {
            Department department = new Department();
            BeanUtils.populate(department, map);
            System.out.println(department.getDeptName());

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
    @Test
    public void test1(){
        Record r1 = new Record();
        r1.setName("aaa");
        r1.setDate(new Date());
        Record r2 = new Record();
        try {
            BeanUtils.copyProperties(r1,r2);
            System.out.println(r2.getName());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
