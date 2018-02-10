package com.quest.test.annotation;

import com.quest.commons.annotations.TreeColumn;
import com.quest.commons.annotations.TreeValue;
import com.quest.entity.Region;

import java.lang.reflect.Field;

import java.util.*;

import org.apache.poi.ss.formula.functions.T;
import org.junit.Test;

/**
 * Created by Quest on 2018/1/9.
 */
public class TreeColumnTest {
    @Test
    public void test(){
        Region region = new Region();
        region.setId(111);
        region.setParentId(0);
        region.setName("aaa");
        getReflect(region);
    }

    private void getReflect(Object obj){
        try {
            Class cls = obj.getClass();
            for(Field field : cls.getDeclaredFields()){
                TreeColumn column = field.getDeclaredAnnotation(TreeColumn.class);
                if(column != null){
                    field.setAccessible(true);
                    switch (column.type()){
                        case ID:
                            System.out.println("id:"+field.get(obj));break;
                        case PID:
                            System.out.println("pid:"+field.get(obj));break;
                        case TITLE:
                            System.out.println("title:"+field.get(obj));break;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
