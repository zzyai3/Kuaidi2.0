package com.example.zhouzhongyi.kuaidi.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.zhouzhongyi.kuaidi.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class NormalRecyclerViewAdapter extends RecyclerView.Adapter<NormalRecyclerViewAdapter.NormalTextViewHolder> {
    private final LayoutInflater mLayoutInflater;
    private final Context mContext;
    private String[] mTitles1;
    private String[] phones;
    private String[] adreese;
    private String[] price;

    public NormalRecyclerViewAdapter(Context context) {
        mTitles1 = context.getResources().getStringArray(R.array.titles);
        phones = context.getResources().getStringArray(R.array.phones);
        adreese = context.getResources().getStringArray(R.array.adresses);
        price = context.getResources().getStringArray(R.array.prices);
        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public NormalTextViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new NormalTextViewHolder(mLayoutInflater.inflate(R.layout.item_text, parent, false));
    }

    @Override
    public void onBindViewHolder(NormalTextViewHolder holder, int position) {
        holder.mTextView.setText("用户姓名:");
        holder.mTextView2.setText("用户电话:");
        holder.mTextView3.setText("用户地址:");
        holder.mTextView4.setText("用户商品:");
        holder.mTextView5.setText(mTitles1[position]);
        holder.mTextView6.setText(phones[position]);
        holder.mTextView7.setText(adreese[position]);
        holder.mTextView8.setText(price[position]);

    }

    @Override
    public int getItemCount() {
        return mTitles1 == null ? 0 : mTitles1.length;
    }

    public static class NormalTextViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.text_view)
        TextView mTextView;
        @Bind(R.id.text_view2)
        TextView mTextView2;
        @Bind(R.id.text_view3)
        TextView mTextView3;
        @Bind(R.id.text_view4)
        TextView mTextView4;
        @Bind(R.id.text_view5)
        TextView mTextView5;
        @Bind(R.id.text_view6)
        TextView mTextView6;
        @Bind(R.id.text_view7)
        TextView mTextView7;
        @Bind(R.id.text_view8)
        TextView mTextView8;


        NormalTextViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        @OnClick(R.id.cv_item)
        void onItemClick() {
            Log.d("NormalTextViewHolder", "onClick--> position = " + getPosition());
        }
    }
}
