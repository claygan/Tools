package com.quest.test.beanUtils;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import com.quest.test.beanUtils.entitys.DestObject;
import com.quest.test.beanUtils.entitys.SonSourceObject;
import com.quest.test.beanUtils.entitys.SourceObject;
import org.apache.commons.beanutils.*;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.Map;

/**
 * Created by Quest on 2018/8/6.
 */
public class TestDemo {
    @Test
    public void son() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        SourceObject parent = new SourceObject();
        parent.setCode("tom");
        parent.setId(123);
        parent.setPid(456);

        SonSourceObject son = new SonSourceObject();
        son.setName("jerry");

//            org.apache.commons.beanutils.BeanUtils.copyProperties(source, dest);
//            org.apache.commons.beanutils.PropertyUtils.copyProperties(source, dest);
//        org.springframework.beans.BeanUtils.copyProperties(parent, son);
//        PojoUtil.convert(parent, son);
        System.out.println(JSON.toJSONString(parent));
        System.out.println(JSON.toJSONString(son));

    }
    @Test
    public void test1() throws InvocationTargetException, IllegalAccessException {
        SourceObject source = new SourceObject();
        source.setId(111);
        source.setPid(222);
        source.setCode("curry");
        source.setDate(new Date());
        source.setSqlDate(new java.sql.Date(System.currentTimeMillis()));

        DestObject dest = new DestObject();
        org.springframework.beans.BeanUtils.copyProperties(source, dest);
        System.out.println("-------------------------------------------->spring:"+JSON.toJSONString(dest));
        System.out.println("-------------------------------------------->spring:"+JSON.toJSONString(source));

        DestObject dest1 = new DestObject();
        org.apache.commons.beanutils.BeanUtils.copyProperties(source,dest1);
        System.out.println("-------------------------------------------->apache:"+JSON.toJSONString(dest1));
        System.out.println("-------------------------------------------->apache:"+JSON.toJSONString(source));
    }

    @Test
    public void map() throws Exception {
        SourceObject source = new SourceObject();
        source.setCode("curry");
        source.setPid(30);

        System.out.println(JSON.toJSONString(BeanUtils.objectToMap(source)));
    }

}
