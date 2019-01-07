package com.zhuandian.oderapp.business;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.zhuandian.oderapp.R;
import com.zhuandian.oderapp.base.BaseActivity;
import com.zhuandian.oderapp.entity.SweetFoodEntity;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * desc :
 * author：xiedong
 * date：2018/12/29
 */
public class FoodDetailActivity extends BaseActivity {
    @BindView(R.id.iv_food)
    ImageView ivFood;
    @BindView(R.id.tv_food_name)
    TextView tvFoodName;
    @BindView(R.id.tv_food_desc)
    TextView tvFoodDesc;
    @BindView(R.id.tv_food_price)
    TextView tvFoodPrice;
    @BindView(R.id.iv_del_food)
    ImageView ivDelFood;
    @BindView(R.id.tv_food_count)
    TextView tvFoodCount;
    @BindView(R.id.ll_alert_order)
    LinearLayout llAlertOrder;
    @BindView(R.id.iv_add_food)
    ImageView ivAddFood;
    private SweetFoodEntity sweetFoodEntity;


    @Override
    protected int getLayoutId() {
        return R.layout.actitity_food_detail;
    }

    @Override
    public void initView() {
        sweetFoodEntity = (SweetFoodEntity) getIntent().getSerializableExtra("food");
        Glide.with(this).load(sweetFoodEntity.getFoodImgUrl()).into(ivFood);
        tvFoodName.setText(sweetFoodEntity.getFoodName());
        tvFoodDesc.setText(sweetFoodEntity.getFoodDesc());
        tvFoodPrice.setText("￥" + sweetFoodEntity.getFoodPrice());
    }


    @OnClick({R.id.iv_del_food, R.id.iv_add_food, R.id.tv_back})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_del_food:
                break;
            case R.id.iv_add_food:
                break;
            case R.id.tv_back:
                finish();
                break;
        }
    }
}
