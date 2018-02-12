package com.quest.test.hashMap;

/**
 * Created by Quest on 2018/2/11.
 */
public class QuestHashMapTest {
    public static void main(String[] args) {
        QuestHashMap<String, String> map = new QuestHashMap<String, String>();
        map.put("1", "勇士");
        map.put("2", "火箭");
        map.put("3", "骑士");
        map.put("4", "马刺");
        map.put("5", "热火");
        map.put("6", "雷霆");
        map.put("7", "奇才");
        map.put("8", "篮网");
        map.put("9", "湖人");
        map.put("10", "森林狼");
        map.put("11", "凯尔特人");
        map.put("12", "开拓者");
        map.put("13", "步行者");
        map.put("14", "掘金");
        map.put("15", "鹈鹕");
        map.put("16", "快船");
        map.put("17", "太阳");
        map.put("18", "国王");
        map.put("19", "猛龙");
        map.put("20", "雄鹿");
        map.put("21", "76人");
        map.put("22", "活塞");
        map.put("23", "黄蜂");
        map.put("24", "尼克斯");
        map.put("25", "公牛");
        map.put("26", "魔术");
        map.put("27", "老鹰");
        map.put("28", "爵士");
        map.put("29", "灰熊");
        map.put("30", "独行侠");
        map.print();
        System.out.println(map.get("23"));
    }
}
