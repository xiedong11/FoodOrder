package com.zhuandian.oderapp.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zhuandian.oderapp.R;

import butterknife.BindView;

/**
 * desc :订单类别fragment
 * author：xiedong
 * data：2018/12/28
 */
public class CategorgFragment extends Fragment {
    @BindView(R.id.rv_list)
    RecyclerView rvList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category, container, false);
        return view;
    }


}
