package com.zhuandian.oderapp.Utils;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;

import com.zhuandian.oderapp.R;

/**
 * desc :
 * author：xiedong
 * date：2019/1/8
 */
public class ViewUtils {
    /**
     * 设置view选中动画（首页底部tab）
     *
     * @param context
     * @param view
     */
    public static void setViewSelectAnimation(Context context, View view) {
        Animation viewShakeAnimation = AnimationUtils.loadAnimation(context, R.anim.view_shake);
        Animation viewScaleAnimation = AnimationUtils.loadAnimation(context, R.anim.view_scale);

        AnimationSet animationSet = new AnimationSet(false);
        animationSet.addAnimation(viewShakeAnimation);
        animationSet.addAnimation(viewScaleAnimation);

        view.setAnimation(animationSet);
        view.startAnimation(animationSet);
    }
}
