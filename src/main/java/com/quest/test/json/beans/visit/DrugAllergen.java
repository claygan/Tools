package com.quest.test.json.beans.visit;

import java.io.Serializable;

/**
 * Created by Quest on 2018/8/21.
 */
public class DrugAllergen implements Serializable {
    private String code;//过敏史编码1无 有：2青霉素 3 磺胺 4 链霉素 5其他
    private String drugAllergenOther;//药物过敏史其他名称

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDrugAllergenOther() {
        return drugAllergenOther;
    }

    public void setDrugAllergenOther(String drugAllergenOther) {
        this.drugAllergenOther = drugAllergenOther;
    }
}
