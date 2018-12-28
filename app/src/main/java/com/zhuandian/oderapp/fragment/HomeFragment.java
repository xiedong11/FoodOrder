package com.zhuandian.oderapp.fragment;

import com.zhuandian.oderapp.R;
import com.zhuandian.oderapp.base.BaseFragment;

/**
 * desc :首页
 * author：xiedong
 * data：2018/12/28
 */
public class HomeFragment extends BaseFragment {
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initData() {
        getActivity().getSupportFragmentManager().beginTransaction().add(R.id.rl_category_list_container, new CategorgFragment()).commit();
        getActivity().getSupportFragmentManager().beginTransaction().add(R.id.rl_food_list_container, new FoodFragment()).commit();
    }
}
