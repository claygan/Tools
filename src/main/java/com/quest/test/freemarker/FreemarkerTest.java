package com.quest.test.freemarker;

import com.quest.commons.utils.FreemarkerUtil;
import org.apache.commons.collections.map.HashedMap;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Quest on 2017/12/28.
 */
public class FreemarkerTest {
    @Test
    public void generate(){
        String tempPath = "template/java.ftl";
        String outPath = "src/test/java";
        String name = "user.java";
        Map<String, Object> context = new HashedMap();
        context.put("basePackageName", "com.quest");
        context.put("projectName", "user");
        context.put("modelClassSimpleName", "User");

        List<Property> propertyList = new ArrayList<>();
        Property property = new Property();
        property.setName("userName");
        property.setResultType("String");
        propertyList.add(property);
        Property property1 = new Property();
        property1.setName("age");
        property1.setResultType("int");
        propertyList.add(property1);
        context.put("propertyList", propertyList);

        FreemarkerUtil.generateFile(tempPath, outPath, name, context);
    }

}
