package com.example.zhouzhongyi.kuaidi.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.zhouzhongyi.kuaidi.Helper.Helper;
import com.example.zhouzhongyi.kuaidi.R;
import com.example.zhouzhongyi.kuaidi.bean.Shoppingbean;

import java.util.List;

import butterknife.OnClick;

/**
 * Created by zhouzhongyi on 16/3/11.
 */
public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.OrderTextViewHolder> {

    private List<Shoppingbean> orderList1;

    private Context context;

    private LayoutInflater mLayoutInflater;
    private CardView cardView;


    public OrderAdapter(Context context) {

        orderList1 = Helper.orderList1;

        this.context = context;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public OrderTextViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new OrderTextViewHolder(mLayoutInflater.inflate(R.layout.order_item, parent, false));
    }

    @Override
    public void onBindViewHolder(OrderTextViewHolder holder, final int position) {
        //   DemoItem item = DemoItem.fromCursor(cursor);
       // holder.text_view.setText("用户姓名:");
        holder.text_view2.setText("用户电话:");
        holder.text_view3.setText("用户地址:");
        holder.text_view4.setText("用户商品:");
        holder.text_view9.setText("商品数量:");

       // holder.text_view5.setText();
        holder.text_view6.setText(orderList1.get(position).getPhone());
        holder.text_view7.setText(orderList1.get(position).getAddress());
        holder.text_view8.setText(orderList1.get(position).getGoodsname());
        holder.text_view10.setText(String.valueOf(orderList1.get(position).getGoodsnumm().intValue()));


        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("提示");
                builder.setMessage("接单成功");
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {


                    }
                });
                builder.create().show();
//                Intent intent=new Intent(context,ShoppingmoreActivity.class);
//                System.err.print("------------->>>"+shoppingList);
//                intent.putExtra("Shop", shoppingList.get(position));
//                // intent.putExtra("News",newses.get(j));
//                context .startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return orderList1 == null ? 0 : orderList1.size();
    }

    public static class OrderTextViewHolder extends RecyclerView.ViewHolder {
//        @Bind(R.id.sp_view)
//        TextView mTextView;
//        @Bind(R.id.sp_view2)
//        TextView mTextView2;
//        @Bind(R.id.sp_view3)
//        TextView mTextView3;
//        @Bind(R.id.cv_item)
//        CardView cardView;
//
//
//        @Bind(R.id.sp_view5)
//        TextView mTextView5;
//        @Bind(R.id.sp_view6)
//        TextView mTextView6;
//        @Bind(R.id.sp_view7)
//        TextView mTextView7;
       // TextView text_view;
       // TextView text_view5;
        TextView text_view2;
        TextView text_view6;


        TextView text_view3;
        TextView text_view7;
        TextView text_view4;
        TextView text_view8;
        TextView text_view9;
        TextView text_view10;
        CardView cardView;




        OrderTextViewHolder(View view) {
            super(view);
        //    ButterKnife.bind(this, view);
         //   text_view = (TextView)itemView.findViewById(R.id.text_view);
            text_view2 = (TextView)itemView.findViewById(R.id.text_view2);
            text_view3 = (TextView)itemView.findViewById(R.id.text_view3);
            text_view4 = (TextView)itemView.findViewById(R.id.text_view4);
           // text_view5 = (TextView)itemView.findViewById(R.id.text_view5);
            text_view6 = (TextView)itemView.findViewById(R.id.text_view6);
            text_view7 = (TextView)itemView.findViewById(R.id.text_view7);
            text_view8 = (TextView)itemView.findViewById(R.id.text_view8);
            text_view9 = (TextView)itemView.findViewById(R.id.text_view9);
            text_view10 = (TextView)itemView.findViewById(R.id.text_view10);
            cardView = (CardView)itemView.findViewById(R.id.cv_item6);
        }

        @OnClick(R.id.cv_item)
        void onItemClick() {
            //   DemoItem item = DemoItem.fromCursor((Cursor) mAdapter.getItem(getPosition()));

            //   Intent intent = new Intent(,ShoppingmoreActivity.class);


            Log.d("NormalTextViewHolder", "onClick--> position = " + getPosition());
        }
    }
}
