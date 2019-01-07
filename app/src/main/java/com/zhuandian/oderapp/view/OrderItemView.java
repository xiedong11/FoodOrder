package com.zhuandian.oderapp.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zhuandian.oderapp.R;
import com.zhuandian.oderapp.entity.OrderEntity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * desc :
 * author：xiedong
 * date：2019/1/4
 */
public class OrderItemView extends RelativeLayout {
    @BindView(R.id.iv_food)
    ImageView ivFood;
    @BindView(R.id.tv_food_desc)
    TextView tvFoodDesc;
    @BindView(R.id.tv_food_price)
    TextView tvFoodPrice;

    public OrderItemView(Context context) {
        this(context, null);
    }

    public OrderItemView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public OrderItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.view_order_item, this);
        ButterKnife.bind(this, view);
    }

    public void setItemData(Context context, OrderEntity orderEntity) {
        Glide.with(context).load(orderEntity.getFoodUrl()).into(ivFood);
        tvFoodDesc.setText(orderEntity.getOrderName());
        tvFoodPrice.setText(String.format("%d*%.2f", orderEntity.getOrderCount(), orderEntity.getOrderPrice()));
    }
}
