package com.quest.test.beanUtils.entitys;

import java.io.Serializable;

public class Goods implements Serializable {
    private String cate;
    private int num;

    public Goods() {
    }

    public Goods(String cate, int num) {
        this.cate = cate;
        this.num = num;
    }

    public String getCate() {
        return cate;
    }

    public Goods setCate(String cate) {
        this.cate = cate;
        return this;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "cate='" + cate + '\'' +
                ", num=" + num +
                '}';
    }
}
