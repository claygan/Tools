package com.quest.test.beanUtils;

import com.alibaba.fastjson.JSON;
import com.quest.test.beanUtils.entitys.DestObject;
import com.quest.test.beanUtils.entitys.SourceObject;
import org.junit.Test;
import org.springframework.beans.*;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by Quest on 2018/8/6.
 */
public class TestDemo {
    @Test
    public void bean() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        SourceObject source = new SourceObject();
        source.setCode("tom");
        source.setId(123);
        source.setPid(456);

        DestObject dest = new DestObject();
        dest.setName("jerry");

//            org.apache.commons.beanutils.BeanUtils.copyProperties(source, dest);
//            org.apache.commons.beanutils.PropertyUtils.copyProperties(source, dest);
        org.springframework.beans.BeanUtils.copyProperties(source, dest);

        System.out.println(JSON.toJSONString(source));
        System.out.println(JSON.toJSONString(dest));

    }
    @Test
    public void test1() throws InvocationTargetException, IllegalAccessException {
        SourceObject source1 = new SourceObject();
        source1.setPid(111);

        SourceObject source = new SourceObject();
        source.setCode("tom");
        source.setId(123);
        source.setPid(456);
//        org.springframework.beans.BeanUtils.copyProperties(source1, source);
        //org.apache.commons.beanutils.BeanUtils.copyProperties(source1,source);
        BeanUtils.copyProperties(source1, source);
        System.out.println(JSON.toJSONString(source));

    }
}
