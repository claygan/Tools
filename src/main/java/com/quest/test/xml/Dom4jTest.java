package com.quest.test.xml;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.io.File;
import java.util.List;

/**
 * Created by Quest on 2017/10/19.
 */
public class Dom4jTest {
    @Test
    public void test(){
        SAXReader reader = new SAXReader();
        File file = new File("F:\\Desktop\\spring.xml");
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
}
