package com.zhuandian.oderapp.event;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * desc :需要使用eventbus的activity都需要以注解的方式绑定到此
 * author：xiedong
 * data：2018/12/28
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface BindEventBus {
}
