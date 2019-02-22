package com.quest.test.json.beans.visit;

import java.io.Serializable;

/**
 * Created by Quest on 2018/8/21.
 */
public class DisabilityCode implements Serializable{
    private String code;//残疾情况编码
    private String disabilityOther;//残疾情况-其他名称

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDisabilityOther() {
        return disabilityOther;
    }

    public void setDisabilityOther(String disabilityOther) {
        this.disabilityOther = disabilityOther;
    }
}
