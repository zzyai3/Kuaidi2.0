package com.example.zhouzhongyi.kuaidi.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.zhouzhongyi.kuaidi.R;

import butterknife.ButterKnife;

/**
 * Created by zhouzhongyi on 16/2/27.
 */
public class CheckdoneActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }
}
