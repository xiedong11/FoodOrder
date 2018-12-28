package com.zhuandian.oderapp;

import android.widget.RelativeLayout;
import com.zhuandian.oderapp.base.BaseActivity;
import com.zhuandian.oderapp.fragment.CategorgFragment;
import com.zhuandian.oderapp.fragment.FoodFragment;
import butterknife.BindView;


public class MainActivity extends BaseActivity {
    @BindView(R.id.rl_category_list_container)
    RelativeLayout rlCategoryListContainer;
    @BindView(R.id.rl_food_list_container)
    RelativeLayout rlFoodListContainer;

    @Override
    public void initView() {
        getSupportFragmentManager().beginTransaction().add(R.id.rl_category_list_container, new CategorgFragment()).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.rl_food_list_container, new FoodFragment()).commit();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }
}
