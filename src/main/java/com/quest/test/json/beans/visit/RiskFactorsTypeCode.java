package com.quest.test.json.beans.visit;

import java.io.Serializable;

/**
 * Created by Quest on 2018/8/21.
 */
public class RiskFactorsTypeCode implements Serializable {
    private String code;//暴露史编码：1无 有：2化学品 3 毒物 4 射线

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
