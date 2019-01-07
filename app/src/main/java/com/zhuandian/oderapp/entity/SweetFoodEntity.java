package com.zhuandian.oderapp.entity;

import java.io.Serializable;

import cn.bmob.v3.BmobObject;

/**
 * desc :
 * author：xiedong
 * data：2018/12/28
 */
public class SweetFoodEntity extends BmobObject implements Serializable {
    private String foodImgUrl;
    private String foodDesc;
    private String foodName;
    private int foodType;
    private double foodPrice;
    private String typeName;
    private int foodId;
    private int foodCount; //本地缓存使用，不做网络数据存储

    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

    public int getFoodCount() {
        return foodCount;
    }

    public void setFoodCount(int foodCount) {
        this.foodCount = foodCount;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public double getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(double foodPrice) {
        this.foodPrice = foodPrice;
    }

    public String getFoodImgUrl() {
        return foodImgUrl;
    }

    public void setFoodImgUrl(String foodImgUrl) {
        this.foodImgUrl = foodImgUrl;
    }

    public String getFoodDesc() {
        return foodDesc;
    }

    public void setFoodDesc(String foodDesc) {
        this.foodDesc = foodDesc;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public int getFoodType() {
        return foodType;
    }

    public void setFoodType(int foodType) {
        this.foodType = foodType;
    }
}
