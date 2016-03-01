package com.example.zhouzhongyi.kuaidi.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.zhouzhongyi.kuaidi.R;

import butterknife.ButterKnife;

/**
 * Created by zhouzhongyi on 16/2/19.
 */
public class ShoppingmoreActivity extends AppCompatActivity {
    private TextView tv_shopid;
    private Button bt_check;
    private TextView tv_shopid1;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoppingmore);
       // ButterKnife.bind(this);
        bt_check = (Button)findViewById(R.id.bt_check);
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
