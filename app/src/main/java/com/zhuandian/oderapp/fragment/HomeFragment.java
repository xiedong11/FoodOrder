package com.zhuandian.oderapp.fragment;


import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.zhuandian.oderapp.R;
import com.zhuandian.oderapp.adpter.CategoryListAdapter;
import com.zhuandian.oderapp.adpter.FoodListAdapter;
import com.zhuandian.oderapp.base.BaseFragment;
import com.zhuandian.oderapp.entity.CategoryEntity;
import com.zhuandian.oderapp.entity.FoodEntity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import butterknife.BindView;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

/**
 * desc :首页
 * author：xiedong
 * data：2018/12/28
 */
public class HomeFragment extends BaseFragment {
    @BindView(R.id.rv_category_list)
    RecyclerView rvCategoryList;
    @BindView(R.id.rv_food_list)
    RecyclerView rvFoodList;
    private LinearLayoutManager foodLayoutManager;
    private List<FoodEntity> foodEntityList = new ArrayList<>();
    private List<CategoryEntity> categoryEntityList = new ArrayList<>();
    private CategoryListAdapter categoryListAdapter;
    private int userScrollState;


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initData() {
        initFoodList();
        initCategoryList();
    }

    private void initFoodList() {
        BmobQuery<FoodEntity> query = new BmobQuery<>();
        query.order("-createdA")
                .findObjects(new FindListener<FoodEntity>() {
                    @Override
                    public void done(List<FoodEntity> list, BmobException e) {
                        if (e == null) {
                            Collections.sort(list, new Comparator<FoodEntity>() {
                                @Override
                                public int compare(FoodEntity o1, FoodEntity o2) {
                                    //进行升序排列
                                    if (o1.getFoodType() > o2.getFoodType()) {
                                        return 1;
                                    }
                                    if (o1.getFoodType() == o2.getFoodType()) {
                                        return 0;
                                    }
                                    return -1;
                                    //升序排列
//                                    return o1.getFoodType() + "".compareTo(o2.getFoodType() + "");
                                }
                            });
                            foodEntityList.addAll(list);
                            FoodListAdapter foodListAdapter = new FoodListAdapter(foodEntityList, getActivity());
                            rvFoodList.setAdapter(foodListAdapter);
                            foodListAdapter.notifyDataSetChanged();
                            foodLayoutManager = new LinearLayoutManager(getActivity());
                            rvFoodList.setLayoutManager(foodLayoutManager);
                        } else {
                            Toast.makeText(getActivity(), "数据加载异常", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

        rvFoodList.addOnScrollListener(new RecyclerView.OnScrollListener() {

//            scrollState = SCROLL_STATE_TOUCH_SCROLL(1)：表示正在滚动。当屏幕滚动且用户使用的触碰或手指还在屏幕上时为1
//            scrollState =SCROLL_STATE_FLING(2) ：表示手指做了抛的动作（手指离开屏幕前，用力滑了一下，屏幕产生惯性滑动）。
//            crollState =SCROLL_STATE_IDLE(0) ：表示屏幕已停止。屏幕停止滚动时为0。
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                userScrollState = newState;
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (userScrollState == 1 || userScrollState == 2) {
                    int firstVisibleItemFoodType = foodEntityList.get(foodLayoutManager.findFirstVisibleItemPosition()).getFoodType();
                    for (int i = 0; i < categoryEntityList.size(); i++) {
                        categoryEntityList.get(i).setSelected(false);
                        if (firstVisibleItemFoodType == categoryEntityList.get(i).getType()) {
                            categoryEntityList.get(i).setSelected(true);
                            rvCategoryList.scrollToPosition(i);
                            categoryListAdapter.notifyDataSetChanged();
                        }
                    }
                }
            }
        });
    }

    protected void initCategoryList() {
        BmobQuery<CategoryEntity> query = new BmobQuery<>();
        query.order("-createdA")
                .findObjects(new FindListener<CategoryEntity>() {
                    @Override
                    public void done(List<CategoryEntity> list, BmobException e) {
                        if (e == null) {
                            Collections.sort(list, new Comparator<CategoryEntity>() {
                                @Override
                                public int compare(CategoryEntity o1, CategoryEntity o2) {
                                    //进行升序排列
                                    if (o1.getType() > o2.getType()) {
                                        return 1;
                                    }
                                    if (o1.getType() == o2.getType()) {
                                        return 0;
                                    }
                                    return -1;
                                }
                            });
                            categoryEntityList.addAll(list);
                            categoryListAdapter = new CategoryListAdapter(getActivity(), categoryEntityList);
                            categoryListAdapter.setItemClickListener(new CategoryListAdapter.ItemClickListener() {
                                @Override
                                public void itemClick(int foodType) {

                                    for (int i = 0; i < categoryEntityList.size(); i++) {
                                        categoryEntityList.get(i).setSelected(false);
                                        if (foodType == categoryEntityList.get(i).getType()) {
                                            categoryEntityList.get(i).setSelected(true);
                                            categoryListAdapter.notifyDataSetChanged();
                                        }
                                    }

                                    for (int i = 0; i < foodEntityList.size(); i++) {
                                        if (foodType == foodEntityList.get(i).getFoodType()) {
                                            rvFoodList.scrollToPosition(i);
                                        }
                                    }
                                }
                            });
                            rvCategoryList.setAdapter(categoryListAdapter);
                            rvCategoryList.setLayoutManager(new LinearLayoutManager(getActivity()));
                        } else {
                            Toast.makeText(getActivity(), "数据加载异常", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }


}
