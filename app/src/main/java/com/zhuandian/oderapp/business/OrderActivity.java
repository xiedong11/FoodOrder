package com.zhuandian.oderapp.business;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zhuandian.oderapp.R;
import com.zhuandian.oderapp.base.BaseActivity;
import com.zhuandian.oderapp.entity.SweetFoodEntity;
import com.zhuandian.oderapp.entity.OrderEntity;
import com.zhuandian.oderapp.view.OrderItemView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class OrderActivity extends BaseActivity {

    @BindView(R.id.tv_total_price)
    TextView tvTotalPrice;
    @BindView(R.id.tv_to_order_page)
    TextView tvToOrderPage;
    @BindView(R.id.ll_order_container)
    LinearLayout llOrderContainer;
    private List<SweetFoodEntity> shopCarList;
    private List<OrderEntity> orderEntityList;
    public static final int REQUEST_OPEN_ORDER_PAGE = 1;
    public static final int REQUEST_CLOSE_ORDER_PAGE = 2;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_order;
    }

    @Override
    public void initView() {
        shopCarList = new ArrayList<>();
        orderEntityList = new ArrayList<>();
        shopCarList = (List<SweetFoodEntity>) getIntent().getSerializableExtra("data");
        for (int i = 0; i < shopCarList.size(); i++) {

            boolean isAdd = false;
            if (orderEntityList.size() == 0) {
                OrderEntity orderEntity = new OrderEntity();
                orderEntity.setFoodId(shopCarList.get(i).getFoodId());
                orderEntity.setFoodUrl(shopCarList.get(i).getFoodImgUrl());
                orderEntity.setOrderName(shopCarList.get(i).getFoodName());
                orderEntity.setOrderPrice(shopCarList.get(i).getFoodPrice());
                orderEntity.setOrderCount(1);
                orderEntityList.add(orderEntity);
            } else {
                for (int j = 0; j < orderEntityList.size(); j++) {
                    if (shopCarList.get(i).getFoodId() == orderEntityList.get(j).getFoodId()) {
                        int currentCount = orderEntityList.get(j).getOrderCount() + 1;
                        orderEntityList.get(j).setOrderCount(currentCount);
                        isAdd = true;
                    }
                }
                if (!isAdd) {
                    OrderEntity orderEntity = new OrderEntity();
                    orderEntity.setFoodId(shopCarList.get(i).getFoodId());
                    orderEntity.setFoodUrl(shopCarList.get(i).getFoodImgUrl());
                    orderEntity.setOrderName(shopCarList.get(i).getFoodName());
                    orderEntity.setOrderPrice(shopCarList.get(i).getFoodPrice());
                    orderEntity.setOrderCount(1);
                    orderEntityList.add(orderEntity);
                }


            }
        }
        llOrderContainer.removeAllViews();
        double totalPrice = 0;
        for (OrderEntity orderEntity : orderEntityList) {
            totalPrice += orderEntity.getOrderPrice() * orderEntity.getOrderCount();
            OrderItemView itemView = new OrderItemView(this);
            itemView.setItemData(this, orderEntity);
            llOrderContainer.addView(itemView);
        }
        tvTotalPrice.setText(String.format("￥%.2f", totalPrice));
    }


    @OnClick(R.id.tv_to_order_page)
    public void onClick() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("下单成功")
                .setMessage("下单成功，祝您用餐愉快!!")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        setResult(REQUEST_CLOSE_ORDER_PAGE);
                        finish();
                        dialog.dismiss();
                    }
                })
                .show();
    }
}
