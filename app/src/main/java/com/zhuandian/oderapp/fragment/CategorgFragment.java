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
import com.zhuandian.oderapp.base.BaseFragment;
import com.zhuandian.oderapp.entity.CategoryEntity;
import com.zhuandian.oderapp.event.ChoseTypeEvent;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

/**
 * desc :订单类别fragment
 * author：xiedong
 * data：2018/12/28
 */
public class CategorgFragment extends BaseFragment {
    @BindView(R.id.rv_list)
    RecyclerView rvList;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_category;
    }

    protected void initData() {
        BmobQuery<CategoryEntity> query = new BmobQuery<>();
        query.order("-createdA")
                .findObjects(new FindListener<CategoryEntity>() {
                    @Override
                    public void done(List<CategoryEntity> list, BmobException e) {
                        if (e == null) {
                            CategoryListAdapter categoryListAdapter = new CategoryListAdapter(getActivity(), list);
                            categoryListAdapter.setItemClickListener(new CategoryListAdapter.ItemClickListener() {
                                @Override
                                public void itemClick(int foodType) {
                                    EventBus.getDefault().post(new ChoseTypeEvent(foodType));
                                }
                            });
                            rvList.setAdapter(categoryListAdapter);
                            rvList.setLayoutManager(new LinearLayoutManager(getActivity()));
                        } else {
                            Toast.makeText(getActivity(), "数据加载异常", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }


}
