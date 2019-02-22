package com.quest.test.xml;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.lang.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.util.*;

/**
 * 使用alibaba-fastjson和dom4j作为xml与json转换的工具
 */
public class XmlUtil {
    /**
     * 需要处理的json列表
     */
    private static List<String> dealJsonList = Lists.newArrayList();
    /**
     * 需要处理的xml数据
     */
    private static Map<String, String> dealXmlMap = Maps.newHashMap();
    public XmlUtil(List<String> list){
        dealJsonList.addAll(list);
    }
    public XmlUtil(Map<String, String> map){
        dealXmlMap.putAll(map);
    }
    static{
        dealJsonList.addAll(Arrays.asList(new String[]{"Insulin","DiabetesMedicine","HypertensionMedicineVO","PersonVO","VisitPlan","PastHis","Xds","Fqs","RiskFactorsTypeCode","DrugAllergen","Mqs","Zns"}));
        dealXmlMap.put("hypertensionMedicines", "HypertensionMedicineVO");
        dealXmlMap.put("diabetesMedicines", "DiabetesMedicine");
        dealXmlMap.put("insulin", "Insulin");
    }
    /**
     * xml转json
     */
    public static String xml2Json(String xml) throws Exception {
        if(!isXML(xml)) return xml;
        JSONObject jsonObject = new JSONObject();
        Document document = DocumentHelper.parseText(xml);
        //获取根节点元素对象
        Element root = document.getRootElement();
        iterateNodes(root, jsonObject);
        return convertJson(jsonObject.toJSONString());
    }
    /**
     * json转xml
     */
    public static String json2Xml(JSONObject json){
        StringBuffer sb = new StringBuffer();
        iterateChilds(sb, json);
        return sb.toString();
    }
    /**
     * 判断是否是xml
     */
    public static boolean isXML(String value) {
        try {
            DocumentHelper.parseText(value);
        } catch (DocumentException e) {
            return false;
        }
        return true;
    }
    /**
     * 由于xml与json的差异性，需要对指定内容进行转换
     */
    private static String convertJson(String json){
        for(String key : dealJsonList){
            while(json.contains(key)){
                String data = "{\"" + key + "\":";
                int index = json.indexOf(data);
                if("[".equals(json.charAt(index+data.length())+"")){
                    json = StringUtils.replaceOnce(json, data, "");
                    int index2 = json.indexOf("]", index + 1);
                    json = json.substring(0, index2 + 1) + json.substring(index2 + 2);
                }else{
                    json = StringUtils.replaceOnce(json, data, "[");
                    int index2 = json.indexOf("}", index + 1);
                    json = json.substring(0, index2 + 1) +"]"+ json.substring(index2 + 2);
                }
            }
        }
        return json;
    }
    /**
     * 递归遍历json属性
     */
    private static void iterateChilds(StringBuffer sb,JSONObject json){
        Set<String> keys = json.keySet();
        for (String key : keys) {
            Object value = json.get(key);
            //对象类型，把子元素转换
            if (value instanceof JSONObject) {
                sb.append("<").append(key).append(">");
                boolean special = false;
                if(dealXmlMap.containsKey(key)){
                    special = true;
                    sb.append("<").append(dealXmlMap.get(key)).append(">");
                }
                iterateChilds(sb, (JSONObject) value);
                if(special)sb.append("</").append(dealXmlMap.get(key)).append(">");
                sb.append("</").append(key).append(">");
            }else if (value instanceof JSONArray) {
                //数组类型，遍历数组，并把key作为每个数组的标签名（这是xml数组表达稍微有点特殊的地方）
                JSONArray array = (JSONArray) value;
                Iterator<Object> iterator = array.iterator();
                sb.append("<").append(key).append(">");
                while (iterator.hasNext()) {
                    boolean special = false;
                    if(dealXmlMap.containsKey(key)){
                        special = true;
                        sb.append("<").append(dealXmlMap.get(key)).append(">");
                    }
                    iterateChilds(sb,(JSONObject)iterator.next());
                    if(special)sb.append("</").append(dealXmlMap.get(key)).append(">");
                }
                sb.append("</").append(key).append(">");
            }else{
                sb.append("<").append(key).append(">").append(value).append("</").append(key).append(">");
            }
        }
    }
    /**
     * 递归遍历节点
     */
    private static void iterateNodes(Element node,JSONObject json){
        //获取当前元素的名称
        String nodeName = node.getName();
        //判断已遍历的JSON中是否已经有了该元素的名称
        if(json.containsKey(nodeName)){
            //该元素在同级下有多个
            Object Object = json.get(nodeName);
            JSONArray array = null;
            if(Object instanceof JSONArray){
                array = (JSONArray) Object;
            }else {
                array = new JSONArray();
                array.add(Object);
            }
            //获取该元素下所有子元素
            List<Element> listElement = node.elements();
            if(listElement.isEmpty()){
                //该元素无子元素，获取元素的值
                String nodeValue = node.getTextTrim();
                array.add(nodeValue);
                json.put(nodeName, array);
                return ;
            }
            //有子元素
            JSONObject newJson = new JSONObject();
            //遍历所有子元素
            for(Element e:listElement){
                //递归
                iterateNodes(e,newJson);
            }
            array.add(newJson);
            json.put(nodeName, array);
            return ;
        }
        //该元素同级下第一次遍历
        //获取该元素下所有子元素
        List<Element> listElement = node.elements();
        if(listElement.isEmpty()){
            //该元素无子元素，获取元素的值
            String nodeValue = node.getTextTrim();
            json.put(nodeName, nodeValue);
            return ;
        }
        //有子节点，新建一个JSONObject来存储该节点下子节点的值
        JSONObject object = new JSONObject();
        //遍历所有一级子节点
        for(Element e:listElement){
            //递归
            iterateNodes(e,object);
        }
        json.put(nodeName, object);
        return ;
    }
}
