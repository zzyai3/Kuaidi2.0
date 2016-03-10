package com.example.zhouzhongyi.kuaidi.activity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.zhouzhongyi.kuaidi.Helper.Shop;
import com.example.zhouzhongyi.kuaidi.R;
import com.example.zhouzhongyi.kuaidi.bean.Goodsbean;

import butterknife.ButterKnife;

/**
 * Created by zhouzhongyi on 16/2/19.
 * 下单页面
 */
public class ShoppingmoreActivity extends AppCompatActivity {
    private TextView tv_shopid;
    private Button bt_check;
    private TextView tv_shopid1;
    private TextView tv_price1;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoppingmore);
        tv_shopid1 = (TextView)findViewById(R.id.tv_goodsname);
        tv_price1 = (TextView)findViewById(R.id.tv_price1);


       //ButterKnife.bind(this);
        bt_check = (Button)findViewById(R.id.bt_check);
        Intent intent = getIntent();

        Goodsbean item= (Goodsbean) intent.getSerializableExtra("Shop");
      //  newsPhoto.setImageResource(item.getPhotoId());

        tv_shopid1.setText(item.getGoodsname());
       tv_price1.setText(item.getGoodsprice());



        bt_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {






                Intent intent = new Intent();

                intent.setClass(ShoppingmoreActivity.this, CheckdoneActivity.class);
                ShoppingmoreActivity.this.startActivity(intent);
            }
        });



    }
}
