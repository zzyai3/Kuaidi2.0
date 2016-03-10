package com.example.zhouzhongyi.kuaidi.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.zhouzhongyi.kuaidi.R;

/**
 * Created by zhouzhongyi on 16/3/8.
 * 快递员接单页面
 */
public class AddmoreActivity extends AppCompatActivity {
    private Button bt_checkorder;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoppingmore);
        // ButterKnife.bind(this);
        bt_checkorder = (Button)findViewById(R.id.bt_checkorder);
        bt_checkorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent();

                intent.setClass(AddmoreActivity.this, CheckdoneActivity.class);
                AddmoreActivity.this.startActivity(intent);
            }
        });



    }
}