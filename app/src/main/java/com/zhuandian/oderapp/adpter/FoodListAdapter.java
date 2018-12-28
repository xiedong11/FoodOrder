package com.zhuandian.oderapp.adpter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zhuandian.oderapp.R;
import com.zhuandian.oderapp.entity.FoodEntity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * desc :食物列表adapter
 * author：xiedong
 * data：2018/12/28
 */
public class FoodListAdapter extends RecyclerView.Adapter<FoodListAdapter.ViewHolder> {
    private List<FoodEntity> mDatas;
    private Context context;

    public FoodListAdapter(List<FoodEntity> mDatas, Context context) {
        this.mDatas = mDatas;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_food_list, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Glide.with(context).load(mDatas.get(i).getFoodImgUrl()).into(viewHolder.ivFood);
        viewHolder.tvFoodName.setText(mDatas.get(i).getFoodName());
        viewHolder.tvFoodDesc.setText(mDatas.get(i).getFoodDesc());
        viewHolder.tvFoodPrice.setText("￥" + mDatas.get(i).getFoodPrice());
    }

    @Override
    public int getItemCount() {
        return mDatas == null ? 0 : mDatas.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_food)
        ImageView ivFood;
        @BindView(R.id.tv_food_name)
        TextView tvFoodName;
        @BindView(R.id.tv_food_desc)
        TextView tvFoodDesc;
        @BindView(R.id.tv_food_price)
        TextView tvFoodPrice;
        @BindView(R.id.iv_add_food)
        ImageView ivAddFood;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
