package com.quest.test.json.beans.visit;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Quest on 2018/8/21.
 */
public class Other implements Serializable {

    private List<DrugAllergen> drugAllergens;//药物过敏史List
    private List<RiskFactorsTypeCode> riskFactorsTypeCodes;//暴露史
    private List<PastHis> pastHiss;//疾病史
    private String operationHistoryFlag;//手术史标志：1：无，2：有
    private List<OperationHistory> operationHistorys;//手术史
    private List<Fqs> fqs;//家族史-父亲
    private List<Mqs> mqs;//家族史-母亲
    private List<Xds> xds;//家族史-兄弟
    private List<Zns> zns;//家族史-子女
    private String geneticDiseaseHistoryFlag;//遗传病史标志：1：无，2：有
    private String geneticDiseaseHistory;//遗传病史名称
    private List<DisabilityCode> disabilityCodes;//残疾情况

    public List<DrugAllergen> getDrugAllergens() {
        return drugAllergens;
    }

    public void setDrugAllergens(List<DrugAllergen> drugAllergens) {
        this.drugAllergens = drugAllergens;
    }

    public List<RiskFactorsTypeCode> getRiskFactorsTypeCodes() {
        return riskFactorsTypeCodes;
    }

    public void setRiskFactorsTypeCodes(List<RiskFactorsTypeCode> riskFactorsTypeCodes) {
        this.riskFactorsTypeCodes = riskFactorsTypeCodes;
    }

    public List<PastHis> getPastHiss() {
        return pastHiss;
    }

    public void setPastHiss(List<PastHis> pastHiss) {
        this.pastHiss = pastHiss;
    }

    public String getOperationHistoryFlag() {
        return operationHistoryFlag;
    }

    public void setOperationHistoryFlag(String operationHistoryFlag) {
        this.operationHistoryFlag = operationHistoryFlag;
    }

    public List<OperationHistory> getOperationHistorys() {
        return operationHistorys;
    }

    public void setOperationHistorys(List<OperationHistory> operationHistorys) {
        this.operationHistorys = operationHistorys;
    }

    public List<Fqs> getFqs() {
        return fqs;
    }

    public void setFqs(List<Fqs> fqs) {
        this.fqs = fqs;
    }

    public List<Mqs> getMqs() {
        return mqs;
    }

    public void setMqs(List<Mqs> mqs) {
        this.mqs = mqs;
    }

    public List<Xds> getXds() {
        return xds;
    }

    public void setXds(List<Xds> xds) {
        this.xds = xds;
    }

    public List<Zns> getZns() {
        return zns;
    }

    public void setZns(List<Zns> zns) {
        this.zns = zns;
    }

    public String getGeneticDiseaseHistoryFlag() {
        return geneticDiseaseHistoryFlag;
    }

    public void setGeneticDiseaseHistoryFlag(String geneticDiseaseHistoryFlag) {
        this.geneticDiseaseHistoryFlag = geneticDiseaseHistoryFlag;
    }

    public String getGeneticDiseaseHistory() {
        return geneticDiseaseHistory;
    }

    public void setGeneticDiseaseHistory(String geneticDiseaseHistory) {
        this.geneticDiseaseHistory = geneticDiseaseHistory;
    }

    public List<DisabilityCode> getDisabilityCodes() {
        return disabilityCodes;
    }

    public void setDisabilityCodes(List<DisabilityCode> disabilityCodes) {
        this.disabilityCodes = disabilityCodes;
    }
}
