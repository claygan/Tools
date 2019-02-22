package com.quest.test.json.beans.visit;

import java.io.Serializable;

/**
 * Created by Quest on 2018/8/21.
 */
public class Xds implements Serializable {
    private String code;//家族史编码
    private String xdo;//家族史-兄弟-其他名称

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getXdo() {
        return xdo;
    }

    public void setXdo(String xdo) {
        this.xdo = xdo;
    }
}
