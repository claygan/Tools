package com.quest.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Quest on 2017/8/31.
 */
public class Record implements Serializable {
    private String name;
    private Date date;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
