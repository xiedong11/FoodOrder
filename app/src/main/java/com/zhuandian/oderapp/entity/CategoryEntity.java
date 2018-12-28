package com.zhuandian.oderapp.entity;

import cn.bmob.v3.BmobObject;

/**
 * desc :类别实体类
 * author：xiedong
 * data：2018/12/28
 */
public class CategoryEntity extends BmobObject {
    private String name;
    private int type;
    private boolean isSelected;

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
