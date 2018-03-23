package com.quest.test.reflect.entity;

import java.io.Serializable;

/**
 * Created by Quest on 2018/3/14.
 */
public class OrderInfo implements Serializable {
    private static final long serialVersionUID = -8194781812074391179L;

    private String areaCode;
    private String areaTitle;

    public OrderInfo(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getAreaTitle() {
        return areaTitle;
    }

    public void setAreaTitle(String areaTitle) {
        this.areaTitle = areaTitle;
    }

    @Override
    public String toString() {
        return "OrderInfo{" +
                "areaCode='" + areaCode + '\'' +
                ", areaTitle='" + areaTitle + '\'' +
                '}';
    }
}
