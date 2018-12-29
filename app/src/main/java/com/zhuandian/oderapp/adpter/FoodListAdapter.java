package com.zhuandian.oderapp.adpter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zhuandian.oderapp.R;
import com.zhuandian.oderapp.entity.FoodEntity;
import com.zhuandian.oderapp.event.AlertOrderEvent;

import org.greenrobot.eventbus.EventBus;

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
    private OnItemClickListener itemClickListener;

    public void setItemClickListener(OnItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

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
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        Glide.with(context).load(mDatas.get(i).getFoodImgUrl()).into(viewHolder.ivFood);
        viewHolder.tvFoodName.setText(mDatas.get(i).getFoodName());
        viewHolder.tvFoodDesc.setText(mDatas.get(i).getFoodDesc());
        viewHolder.tvFoodPrice.setText("￥" + mDatas.get(i).getFoodPrice());
        viewHolder.ivAddFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDatas.get(i).setFoodCount(mDatas.get(i).getFoodCount() + 1);
                EventBus.getDefault().post(new AlertOrderEvent(AlertOrderEvent.ADD_FOOD_ORDER, mDatas.get(i)));
                notifyDataSetChanged();
            }
        });
        viewHolder.ivDelFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mDatas.get(i).getFoodCount() > 0)
                    mDatas.get(i).setFoodCount(mDatas.get(i).getFoodCount() - 1);
                EventBus.getDefault().post(new AlertOrderEvent(AlertOrderEvent.DEL_FOOD_ORDER, mDatas.get(i)));
                notifyDataSetChanged();
            }
        });
        viewHolder.llAlertOrder.setVisibility(mDatas.get(i).getFoodCount() > 0 ? View.VISIBLE : View.GONE);
        viewHolder.tvFoodCount.setText(mDatas.get(i).getFoodCount() + "");
        viewHolder.rlRootContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (itemClickListener != null) {
                    itemClickListener.onClick(mDatas.get(i));
                }
            }
        });
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
        @BindView(R.id.iv_del_food)
        ImageView ivDelFood;
        @BindView(R.id.tv_food_count)
        TextView tvFoodCount;
        @BindView(R.id.iv_add_food)
        ImageView ivAddFood;
        @BindView(R.id.ll_alert_order)
        LinearLayout llAlertOrder;
        @BindView(R.id.rl_root_container)
        RelativeLayout rlRootContainer;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public interface OnItemClickListener {
        void onClick(FoodEntity foodEntity);
    }
}
