package com.quest.test.json.beans.visit;

import java.io.Serializable;

/**
 * Created by Quest on 2018/8/21.
 */
public class Zns implements Serializable {
    private String code;//家族史编码
    private String zno;//家族史-子女-其他名称

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getZno() {
        return zno;
    }

    public void setZno(String zno) {
        this.zno = zno;
    }
}
