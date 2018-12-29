package com.zhuandian.oderapp.adpter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.zhuandian.oderapp.base.BaseFragment;

import java.util.List;

/**
 * desc :
 * author：xiedong
 * data：2018/12/28
 */
public class HomeViewPageAdapter extends FragmentPagerAdapter {
    private List<BaseFragment> fragmentList;
    private String[] tabTitle = {"点餐", "商家"};

    public HomeViewPageAdapter(FragmentManager fm, List<BaseFragment> fragmentList) {
        super(fm);
        this.fragmentList = fragmentList;
    }

    @Override
    public Fragment getItem(int i) {
        return fragmentList.get(i);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitle[position];
    }
}
