package com.zhuandian.oderapp.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.zhuandian.oderapp.R;
import com.zhuandian.oderapp.adpter.CategoryListAdapter;
import com.zhuandian.oderapp.adpter.FoodListAdapter;
import com.zhuandian.oderapp.base.BaseFragment;
import com.zhuandian.oderapp.entity.CategoryEntity;
import com.zhuandian.oderapp.entity.FoodEntity;
import com.zhuandian.oderapp.event.BindEventBus;
import com.zhuandian.oderapp.event.ChoseTypeEvent;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

/**
 * desc :
 * author：xiedong
 * data：2018/12/28
 */
@BindEventBus
public class FoodFragment extends BaseFragment {
    @BindView(R.id.rv_food)
    RecyclerView rvFood;
    private int foodType = 0;


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_food;
    }

    protected void initData() {
        BmobQuery<FoodEntity> query = new BmobQuery<>();
        query.order("-createdA")
                .addWhereEqualTo("foodType", foodType == 0 ? null : foodType)
                .findObjects(new FindListener<FoodEntity>() {
                    @Override
                    public void done(List<FoodEntity> list, BmobException e) {
                        if (e == null) {
                            FoodListAdapter categoryListAdapter = new FoodListAdapter(list, getActivity());
                            rvFood.setAdapter(categoryListAdapter);
                            categoryListAdapter.notifyDataSetChanged();
                            rvFood.setLayoutManager(new LinearLayoutManager(getActivity()));
                        } else {
                            Toast.makeText(getActivity(), "数据加载异常", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void onEventBusReceiveNotice(ChoseTypeEvent choseTypeEvent) {
        foodType = choseTypeEvent.getType();
        initData();
    }

}
