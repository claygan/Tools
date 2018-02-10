package com.quest.entity;

import com.quest.commons.annotations.TreeColumn;
import com.quest.commons.annotations.TreeValue;

/**
 * Created by Quest on 2018/1/9.
 */
public class Region {
    @TreeColumn(type = TreeValue.ID)
    private int id;

    @TreeColumn(type = TreeValue.PID)
    private int parentId;

    @TreeColumn(type = TreeValue.TITLE)
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
