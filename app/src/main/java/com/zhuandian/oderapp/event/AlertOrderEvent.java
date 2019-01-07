package com.zhuandian.oderapp.event;

import com.zhuandian.oderapp.entity.SweetFoodEntity;

/**
 * desc :
 * author：xiedong
 * data：2018/12/28
 */
public class AlertOrderEvent {
    private int type;
    public static final int ADD_FOOD_ORDER = 1;
    public static final int DEL_FOOD_ORDER = 2;
    private SweetFoodEntity sweetFoodEntity;

    public int getType() {
        return type;
    }

    public SweetFoodEntity getSweetFoodEntity() {
        return sweetFoodEntity;
    }

    public AlertOrderEvent(int type, SweetFoodEntity sweetFoodEntity) {
        this.type = type;
        this.sweetFoodEntity = sweetFoodEntity;
    }
}
