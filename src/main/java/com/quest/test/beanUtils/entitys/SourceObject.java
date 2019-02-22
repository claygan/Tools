package com.quest.test.beanUtils.entitys;

import java.util.Date;

/**
 * Created by Quest on 2018/8/6.
 */
public class SourceObject {
    private int id;
    private String code;
    private Integer pid;
    private Date date;
    private java.sql.Date sqlDate;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public java.sql.Date getSqlDate() {
        return sqlDate;
    }

    public void setSqlDate(java.sql.Date sqlDate) {
        this.sqlDate = sqlDate;
    }
}
