package com.zhuandian.oderapp;

import android.support.v4.view.ViewPager;

import com.zhuandian.oderapp.adpter.HomeViewPageAdapter;
import com.zhuandian.oderapp.base.BaseActivity;
import com.zhuandian.oderapp.base.BaseFragment;
import com.zhuandian.oderapp.fragment.HomeFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


public class MainActivity extends BaseActivity {
    @BindView(R.id.vp_page)
    ViewPager vpPage;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        List<BaseFragment> fragments = new ArrayList<>();
        fragments.add(new HomeFragment());
        vpPage.setAdapter(new HomeViewPageAdapter(getSupportFragmentManager(), fragments));
    }


}
