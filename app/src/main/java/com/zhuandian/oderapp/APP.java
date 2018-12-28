package com.zhuandian.oderapp;

import android.app.Application;

import com.zhuandian.oderapp.Utils.Constant;

import cn.bmob.v3.Bmob;

/**
 * desc :
 * author：xiedong
 * data：2018/12/28
 */
public class APP extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Bmob.initialize(this, Constant.APP_ID);
    }
}
