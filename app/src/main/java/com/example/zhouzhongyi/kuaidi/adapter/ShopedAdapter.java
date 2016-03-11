package com.example.zhouzhongyi.kuaidi.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.zhouzhongyi.kuaidi.Helper.ShoppingbeanHelper;
import com.example.zhouzhongyi.kuaidi.R;
import com.example.zhouzhongyi.kuaidi.activity.ShoppingmoreActivity;
import com.example.zhouzhongyi.kuaidi.bean.Shoppingbean;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by zhouzhongyi on 16/3/9.
 * 已购页面适配器
 */
public class ShopedAdapter extends RecyclerView.Adapter<ShopedAdapter.ShoppedTextViewHolder>{
    private final LayoutInflater mLayoutInflater;
    private final Context mContext;
    private CardView cardView;
    private List<Shoppingbean> shoppingList;

    public ShopedAdapter(Context context) {
        this.mContext = context;
        this.mLayoutInflater = LayoutInflater.from(context);
        this.shoppingList = ShoppingbeanHelper.shoppingList;
    }

    @Override
    public ShoppedTextViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ShoppedTextViewHolder(mLayoutInflater.inflate(R.layout.shopped_item, parent, false));
    }

//    @Override
//    public void onBindViewHolder(ShopedAdapter.ShoppedTextViewHolder holder, int position) {
//
//    }

    //@Override
    public void onBindViewHolder(ShoppedTextViewHolder holder, int position) {
        //   DemoItem item = DemoItem.fromCursor(cursor);
        holder.sp_view1.setText("商品名称:");
        holder.sp_view12.setText("购买数量:");
        holder.sp_view13.setText("购买地址:");

        holder.sp_view15.setText(shoppingList.get(position).getGoodsname());
        holder.sp_view16.setText(String.valueOf(shoppingList.get(position).getGoodsnumm().intValue()));
        holder.sp_view17.setText(shoppingList.get(position).getAddress());


//        holder.cardView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent(mContext,ShoppingmoreActivity.class);
//
//                // intent.putExtra("News",newses.get(j));
//                mContext .startActivity(intent);
//            }
//        });

    }

    @Override
    public int getItemCount() {
        return shoppingList == null ? 0 : shoppingList.size();
    }

    public static class ShoppedTextViewHolder extends RecyclerView.ViewHolder {
        TextView sp_view1;

        TextView sp_view12;
        TextView sp_view13;
        TextView sp_view15;
        TextView sp_view16;
        TextView sp_view17;

//        @Bind(R.id.sp_view)
//        TextView mTextView;
//        @Bind(R.id.sp_view2)
//        TextView mTextView2;
//        @Bind(R.id.sp_view3)
//        TextView mTextView3;
//        @Bind(R.id.cv_item)
//        CardView cardView;
//
//        @Bind(R.id.sp_view5)
//        TextView mTextView5;
//        @Bind(R.id.sp_view6)
//        TextView mTextView6;
//        @Bind(R.id.sp_view7)
//        TextView mTextView7;

        ShoppedTextViewHolder(View view) {
            super(view);
            sp_view1 = (TextView)itemView.findViewById(R.id.sp_view1);
            sp_view12 = (TextView)itemView.findViewById(R.id.sp_view12);
            sp_view13 = (TextView)itemView.findViewById(R.id.sp_view13);
            sp_view15 = (TextView)itemView.findViewById(R.id.sp_view15);
            sp_view16 = (TextView)itemView.findViewById(R.id.sp_view16);
            sp_view17 = (TextView)itemView.findViewById(R.id.sp_view17);


          //  ButterKnife.bind(this, view);
        }

        @OnClick(R.id.cv_item3)
        void onItemClick() {
            //   DemoItem item = DemoItem.fromCursor((Cursor) mAdapter.getItem(getPosition()));

            //   Intent intent = new Intent(,ShoppingmoreActivity.class);


            Log.d("NormalTextViewHolder", "onClick--> position = " + getPosition());
        }
    }
}

