package com.zhuandian.oderapp.event;

import com.zhuandian.oderapp.entity.FoodEntity;

/**
 * desc :
 * author：xiedong
 * data：2018/12/28
 */
public class AlertOrderEvent {
    private int type;
    public static final int ADD_FOOD_ORDER = 1;
    public static final int DEL_FOOD_ORDER = 2;
    private FoodEntity foodEntity;

    public int getType() {
        return type;
    }

    public FoodEntity getFoodEntity() {
        return foodEntity;
    }

    public AlertOrderEvent(int type, FoodEntity foodEntity) {
        this.type = type;
        this.foodEntity = foodEntity;
    }
}
