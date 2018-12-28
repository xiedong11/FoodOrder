package com.zhuandian.oderapp.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.zhuandian.oderapp.event.BindEventBus;

import org.greenrobot.eventbus.EventBus;

import butterknife.ButterKnife;

/**
 * desc :
 * author：xiedong
 * data：2018/12/28
 */
abstract public class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        initView();
        if (this.getClass().isAnnotationPresent(BindEventBus.class)) {
            EventBus.getDefault().register(this);
        }
    }

    protected abstract int getLayoutId();

    abstract public void initView();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (this.getClass().isAnnotationPresent(BindEventBus.class)) {
            EventBus.getDefault().register(this);
        }
    }
}
