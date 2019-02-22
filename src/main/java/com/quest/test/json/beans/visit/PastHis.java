package com.quest.test.json.beans.visit;

import java.io.Serializable;

/**
 * Created by Quest on 2018/8/21.
 */
public class PastHis implements Serializable {
    private String pastHisTime;//确诊时间
    private String pastHisName;//疾病史名称

    public String getPastHisTime() {
        return pastHisTime;
    }

    public void setPastHisTime(String pastHisTime) {
        this.pastHisTime = pastHisTime;
    }

    public String getPastHisName() {
        return pastHisName;
    }

    public void setPastHisName(String pastHisName) {
        this.pastHisName = pastHisName;
    }
}
