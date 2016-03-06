package com.example.zhouzhongyi.kuaidi.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.example.zhouzhongyi.kuaidi.R;
import com.example.zhouzhongyi.kuaidi.fragment.ShoppingFragment;

import butterknife.ButterKnife;

/**
 * Created by zhouzhongyi on 16/2/27.
 * 下单成功页面
 */
public class CheckdoneActivity extends AppCompatActivity {
    private Button bt_back;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkdone);
      //  ButterKnife.bind(this);
        bt_back = (Button)findViewById(R.id.bt_back);
        bt_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent();

                intent.setClass(CheckdoneActivity.this, ShoppingActivity.class);
                CheckdoneActivity.this.startActivity(intent);
            }
        });

    }
}
