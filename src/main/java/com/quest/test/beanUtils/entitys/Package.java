package com.quest.test.beanUtils.entitys;

import java.io.Serializable;

public class Package implements Serializable {
    private String name;
    private int weight;
    private Goods goods;

    public Package() {
    }

    public Package(String name, int weight, Goods goods) {
        this.name = name;
        this.weight = weight;
        this.goods = goods;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    @Override
    public String toString() {
        return "Package{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", goods=" + goods +
                '}';
    }
}
