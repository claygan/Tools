package com.quest.test.beanUtils.entitys;

public class Element implements Cloneable{
    private String ele;
    private int num;

    public Element() {
    }

    public Element(String ele, int num) {
        this.ele = ele;
        this.num = num;
    }

    @Override
    public Element clone() {
        try {
            return (Element)super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    public String getEle() {
        return ele;
    }

    public void setEle(String ele) {
        this.ele = ele;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Element{" +
                "ele='" + ele + '\'' +
                ", num=" + num +
                '}';
    }
}
