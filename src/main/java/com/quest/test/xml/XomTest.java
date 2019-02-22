package com.quest.test.xml;

import com.quest.commons.utils.FileUtil;
import net.sf.json.JSONObject;
import net.sf.json.xml.XMLSerializer;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * xom优缺点：
 * 优点：1.封装调用便捷
 * 缺点：1.xml2Json忽略大小写
 *      2.json2xml会加上很多不必要的属性
 */
public class XomTest {
    @Test
    public void xmlTest(){
        /*Path path = Paths.get("F:\\Desktop\\a.xml");
        System.out.println(xml2JSON(FileUtil.readContent(path)));*/
        Path path = Paths.get("F:\\Desktop\\b.json");
        System.out.println(json2XML(FileUtil.readContent(path)));
    }

    public static String xml2JSON(String xml) {
        return new XMLSerializer().read(xml).toString();
    }

    public static String json2XML(String json){
        JSONObject jobj = JSONObject.fromObject(json);
        String xml =  new XMLSerializer().write(jobj);
        return xml;
    }

}
