package com.quest.test.json.beans.visit;

import java.io.Serializable;

/**
 * 个人档案详情（回调）
 */
public class CtsArchiveDetailResponse implements Serializable{
    private String phrId;//个人档案id
    private String personName;//姓名
    private String phoneNumber;//电话
    private String idCard;//身份证
    private String zipCode;//邮编
    private String address;//现住址
    private String contact;//联系人
    private String contactPhone;//联系人电话
    private String sexCode;//性别
    private String registeredPermanent;//常驻类型
    private String bloodTypeCode;//血型
    private String homePlace;//户籍地址
    private String mobileNumber;//手机号码
    private String birthday;//生日yyyy-MM-dd
    private String nationalityCode;//国籍
    private String nationCode;//民族 1.汉族 2.少数民族
    private String rhBloodCode;//RH阴性
    private String workCode;//职业类别
    private String educationCode;//文化程度
    private String insuranceCode;//医疗支付方式
    private String workPlace;//工作单位
    private String insuranceType;//其他支付方式
    private String maritalStatusCode;//婚姻状况
    private String empiId;//个人档案code
    private String manaDoctorId;//责任医生
    private String manaUnitId;//管辖机构
    private String masterFlag;//是否户主：y是 n否
    private String relaCode;//与户主关系
    private String familyId;//家庭档案id
    private String deadFlag;//死亡标志 1死亡 2未死亡
    private String createUnit;//建档单位
    private String createUser;//建档人工号
    private String createDate;//建档日期yyyy-MM-dd
    private String lastModifyDate;//修改日期
    private String status;//档案状态 01正常 02注销
    private String isDiabetes;//是否糖尿病：y是 n否
    private String isHypertension;//是否高血压：y是 n否
    private String cookAirTool;//厨房排风设施
    private String fuelType;//燃料类型
    private String waterSourceCode;//饮水类型
    private String washroom;//厕所类别
    private String livestockColumn;//禽畜栏
    private Other other;////其他信息包括过敏史，暴露史，既往史，家族史，遗传病史，残疾情况

    public String getPhrId() {
        return phrId;
    }

    public void setPhrId(String phrId) {
        this.phrId = phrId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getSexCode() {
        return sexCode;
    }

    public void setSexCode(String sexCode) {
        this.sexCode = sexCode;
    }

    public String getRegisteredPermanent() {
        return registeredPermanent;
    }

    public void setRegisteredPermanent(String registeredPermanent) {
        this.registeredPermanent = registeredPermanent;
    }

    public String getBloodTypeCode() {
        return bloodTypeCode;
    }

    public void setBloodTypeCode(String bloodTypeCode) {
        this.bloodTypeCode = bloodTypeCode;
    }

    public String getHomePlace() {
        return homePlace;
    }

    public void setHomePlace(String homePlace) {
        this.homePlace = homePlace;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getNationalityCode() {
        return nationalityCode;
    }

    public void setNationalityCode(String nationalityCode) {
        this.nationalityCode = nationalityCode;
    }

    public String getNationCode() {
        return nationCode;
    }

    public void setNationCode(String nationCode) {
        this.nationCode = nationCode;
    }

    public String getRhBloodCode() {
        return rhBloodCode;
    }

    public void setRhBloodCode(String rhBloodCode) {
        this.rhBloodCode = rhBloodCode;
    }

    public String getWorkCode() {
        return workCode;
    }

    public void setWorkCode(String workCode) {
        this.workCode = workCode;
    }

    public String getEducationCode() {
        return educationCode;
    }

    public void setEducationCode(String educationCode) {
        this.educationCode = educationCode;
    }

    public String getInsuranceCode() {
        return insuranceCode;
    }

    public void setInsuranceCode(String insuranceCode) {
        this.insuranceCode = insuranceCode;
    }

    public String getWorkPlace() {
        return workPlace;
    }

    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace;
    }

    public String getInsuranceType() {
        return insuranceType;
    }

    public void setInsuranceType(String insuranceType) {
        this.insuranceType = insuranceType;
    }

    public String getMaritalStatusCode() {
        return maritalStatusCode;
    }

    public void setMaritalStatusCode(String maritalStatusCode) {
        this.maritalStatusCode = maritalStatusCode;
    }

    public String getEmpiId() {
        return empiId;
    }

    public void setEmpiId(String empiId) {
        this.empiId = empiId;
    }

    public String getManaDoctorId() {
        return manaDoctorId;
    }

    public void setManaDoctorId(String manaDoctorId) {
        this.manaDoctorId = manaDoctorId;
    }

    public String getManaUnitId() {
        return manaUnitId;
    }

    public void setManaUnitId(String manaUnitId) {
        this.manaUnitId = manaUnitId;
    }

    public String getMasterFlag() {
        return masterFlag;
    }

    public void setMasterFlag(String masterFlag) {
        this.masterFlag = masterFlag;
    }

    public String getRelaCode() {
        return relaCode;
    }

    public void setRelaCode(String relaCode) {
        this.relaCode = relaCode;
    }

    public String getFamilyId() {
        return familyId;
    }

    public void setFamilyId(String familyId) {
        this.familyId = familyId;
    }

    public String getDeadFlag() {
        return deadFlag;
    }

    public void setDeadFlag(String deadFlag) {
        this.deadFlag = deadFlag;
    }

    public String getCreateUnit() {
        return createUnit;
    }

    public void setCreateUnit(String createUnit) {
        this.createUnit = createUnit;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getLastModifyDate() {
        return lastModifyDate;
    }

    public void setLastModifyDate(String lastModifyDate) {
        this.lastModifyDate = lastModifyDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIsDiabetes() {
        return isDiabetes;
    }

    public void setIsDiabetes(String isDiabetes) {
        this.isDiabetes = isDiabetes;
    }

    public String getIsHypertension() {
        return isHypertension;
    }

    public void setIsHypertension(String isHypertension) {
        this.isHypertension = isHypertension;
    }

    public String getCookAirTool() {
        return cookAirTool;
    }

    public void setCookAirTool(String cookAirTool) {
        this.cookAirTool = cookAirTool;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getWaterSourceCode() {
        return waterSourceCode;
    }

    public void setWaterSourceCode(String waterSourceCode) {
        this.waterSourceCode = waterSourceCode;
    }

    public String getWashroom() {
        return washroom;
    }

    public void setWashroom(String washroom) {
        this.washroom = washroom;
    }

    public String getLivestockColumn() {
        return livestockColumn;
    }

    public void setLivestockColumn(String livestockColumn) {
        this.livestockColumn = livestockColumn;
    }

    public Other getOther() {
        return other;
    }

    public void setOther(Other other) {
        this.other = other;
    }
}
