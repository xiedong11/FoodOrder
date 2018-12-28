package com.zhuandian.oderapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RelativeLayout;

import com.zhuandian.oderapp.Utils.Constant;
import com.zhuandian.oderapp.fragment.CategorgFragment;
import com.zhuandian.oderapp.fragment.FoodFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.bmob.v3.Bmob;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.rl_category_list_container)
    RelativeLayout rlCategoryListContainer;
    @BindView(R.id.rl_food_list_container)
    RelativeLayout rlFoodListContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        getSupportFragmentManager().beginTransaction().add(R.id.rl_category_list_container, new CategorgFragment()).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.rl_food_list_container, new FoodFragment()).commit();
    }
}
