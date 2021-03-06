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

import com.example.zhouzhongyi.kuaidi.Helper.Helper;
import com.example.zhouzhongyi.kuaidi.R;
import com.example.zhouzhongyi.kuaidi.activity.ShoppingmoreActivity;
import com.example.zhouzhongyi.kuaidi.bean.Goodsbean;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by zhouzhongyi on 16/1/10.
 * 顾客购物适配器
 */
public class ShopAdapter extends RecyclerView.Adapter<ShopAdapter.ShopTextViewHolder> {

    private List<Goodsbean> goodsList;

    private Context context;

    private LayoutInflater mLayoutInflater;
    private CardView cardView;


    public ShopAdapter(Context context) {
        goodsList = Helper.goodsbeenList;
        this.context = context;
        this.mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public ShopTextViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ShopTextViewHolder(mLayoutInflater.inflate(R.layout.shopping_item, parent, false));
    }

    @Override
    public void onBindViewHolder(ShopTextViewHolder holder, final int position) {
     //   DemoItem item = DemoItem.fromCursor(cursor);
        holder.mTextView.setText("商品:");
        holder.mTextView2.setText("价格:");
        holder.mTextView3.setText("库存:");

        holder.mTextView5.setText(goodsList.get(position).getGoodsname());
        holder.mTextView6.setText(goodsList.get(position).getGoodsprice());
        holder.mTextView7.setText(String.valueOf(goodsList.get(position).getGoodsnum().intValue()));

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,ShoppingmoreActivity.class);
                System.err.print("------------->>>"+goodsList);
                intent.putExtra("Shop", goodsList.get(position));
               // intent.putExtra("News",newses.get(j));
               context .startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return goodsList == null ? 0 : goodsList.size();
    }

    public static class ShopTextViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.sp_view)
        TextView mTextView;
        @Bind(R.id.sp_view2)
        TextView mTextView2;
        @Bind(R.id.sp_view3)
        TextView mTextView3;
        @Bind(R.id.cv_item)
        CardView cardView;


        @Bind(R.id.sp_view5)
        TextView mTextView5;
        @Bind(R.id.sp_view6)
        TextView mTextView6;
        @Bind(R.id.sp_view7)
        TextView mTextView7;



        ShopTextViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        @OnClick(R.id.cv_item)
        void onItemClick() {
         //   DemoItem item = DemoItem.fromCursor((Cursor) mAdapter.getItem(getPosition()));

         //   Intent intent = new Intent(,ShoppingmoreActivity.class);


            Log.d("NormalTextViewHolder", "onClick--> position = " + getPosition());
        }
    }
}
