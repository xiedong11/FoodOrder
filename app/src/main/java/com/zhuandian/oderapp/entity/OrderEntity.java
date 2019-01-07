package com.zhuandian.oderapp.entity;

import java.io.Serializable;

/**
 * desc :
 * author：xiedong
 * date：2019/1/4
 */
public class OrderEntity implements Serializable {
    private String orderName;
    private int foodId;
    private int orderCount;
    private double orderPrice;
    private String foodUrl;

    public String getFoodUrl() {
        return foodUrl;
    }

    public void setFoodUrl(String foodUrl) {
        this.foodUrl = foodUrl;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

    public int getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(int orderCount) {
        this.orderCount = orderCount;
    }

    public double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(double orderPrice) {
        this.orderPrice = orderPrice;
    }
}
