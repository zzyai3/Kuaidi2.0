package com.example.zhouzhongyi.kuaidi.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.example.zhouzhongyi.kuaidi.R;

import butterknife.ButterKnife;

/**
 * Created by zhouzhongyi on 16/2/19.
 */
public class ShoppingmoreActivity extends AppCompatActivity {
    private TextView tv_shopid;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


    }
}
