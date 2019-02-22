package com.quest.test.xml;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.quest.commons.utils.FileUtil;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.naming.NoNameCoder;
import com.thoughtworks.xstream.io.xml.Xpp3Driver;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.StopWatch;
import org.apache.poi.ss.formula.functions.T;
import org.dom4j.*;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

import static org.bouncycastle.asn1.x500.style.RFC4519Style.o;
import static sun.misc.MessageUtils.where;

/**
 * Created by Quest on 2017/10/19.
 */
public class Dom4jTest {
    @Test
    public void test(){
        SAXReader reader = new SAXReader();
        File file = new File("F:\\Desktop\\xml_demo.xml");
        try {
            Document document = reader.read(file);
            Element root = document.getRootElement();
            System.out.println("Root -> " + root.getName() + ":" + root.getTextTrim());
            List<Element> childElements = root.elements();

            for (Element child : childElements) {
                List<Attribute> attributeList = child.attributes();
                System.out.println("Element -> "+child.getName()+":"+child.getText());
                for (Attribute attribute : attributeList) {
                    System.out.println("Attribute -> "+attribute.getName()+":"+attribute.getValue());
                }
            }

        } catch (DocumentException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void toJson() throws Exception {
        Path path = Paths.get("F:\\Desktop\\add.xml");
        StopWatch watch = new StopWatch();
        watch.start();
//        Path path = Paths.get("F:\\Desktop\\a.xml");
        System.out.println(XmlUtil.xml2Json(FileUtil.readContent(path)));
        watch.stop();
        System.out.println(watch.getTime()+"ms");
    }
    @Test
    public void toxml(){
        Path path = Paths.get("F:\\Desktop\\d.json");
        JSONObject parse = JSON.parseObject(FileUtil.readContent(path));
        System.out.println(XmlUtil.json2Xml(parse));
    }

    @Test
    public void isXML() {
        String xml = "<dom>1<dom>";
        System.out.println(isXML(xml));
    }
    public static boolean isXML(String value) {
        try {
            DocumentHelper.parseText(value);
        } catch (DocumentException e) {
            return false;
        }
        return true;
    }
}
