package com.quest.test.json.beans.visit;

import java.io.Serializable;

/**
 * Created by Quest on 2018/8/21.
 */
public class Mqs implements Serializable {
    private String code;//家族史编码
    private String mqo;//家族史-母亲-其他名称

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMqo() {
        return mqo;
    }

    public void setMqo(String mqo) {
        this.mqo = mqo;
    }
}
