package com.zhuandian.oderapp;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.zhuandian.oderapp.adpter.HomeViewPageAdapter;
import com.zhuandian.oderapp.base.BaseActivity;
import com.zhuandian.oderapp.base.BaseFragment;
import com.zhuandian.oderapp.fragment.HomeFragment;
import com.zhuandian.oderapp.fragment.ShopStoreFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends BaseActivity {
    @BindView(R.id.vp_page)
    ViewPager vpPage;
    @BindView(R.id.tab_layout)
    TabLayout tabLayout;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
//        TabLayout.Tab tabOrder = tabLayout.newTab().setText("点餐");
//        TabLayout.Tab tabShopStore = tabLayout.newTab().setText("商家");
//        tabLayout.addTab(tabOrder);
//        tabLayout.addTab(tabShopStore);
        List<BaseFragment> fragments = new ArrayList<>();
        fragments.add(new HomeFragment());
        fragments.add(new ShopStoreFragment());
        vpPage.setAdapter(new HomeViewPageAdapter(getSupportFragmentManager(), fragments));
        tabLayout.setupWithViewPager(vpPage);
    }


}
