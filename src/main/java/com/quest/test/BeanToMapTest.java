package com.quest.test;

import com.alibaba.fastjson.JSON;
import com.quest.commons.utils.BeanUtil;
import com.quest.entity.Record;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Quest on 2017/9/15.
 */
public class BeanToMapTest {
    @Test
    public void test(){
        Record record = new Record();
        record.setName("nb");
        record.setDate(new Date());
        Map map1 = BeanUtil.bean2map(JSON.toJSON(record), true);
        System.out.println(map1.get("map"));
    }
    @Test
    public void test1(){
        Record record = new Record();
        record.setName("nb");
        record.setDate(new Date());
        HashMap map = BeanUtil.beanToMap(record);
        System.out.println(map);
    }
}
