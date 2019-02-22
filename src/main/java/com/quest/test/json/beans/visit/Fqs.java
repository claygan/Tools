package com.quest.test.json.beans.visit;

import java.io.Serializable;

/**
 * Created by Quest on 2018/8/21.
 */
public class Fqs implements Serializable {
    private String code;//家族史编码
    private String fqo;//家族史-父亲-其他名称

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getFqo() {
        return fqo;
    }

    public void setFqo(String fqo) {
        this.fqo = fqo;
    }
}
