package com.example.zhouzhongyi.kuaidi.activity;

import android.app.Activity;
import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import com.example.zhouzhongyi.kuaidi.R;

import butterknife.ButterKnife;

/**
 * Created by zhouzhongyi on 15/12/24.
 */
public class RegisterActicity extends Activity implements View.OnClickListener {
    private EditText et_phonenum;
    private EditText et_passwd;
    private EditText et_passwdcheck;
    private EditText et_yanzheng;
    private Button bt_register;
    private Button bt_yanzhengma;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//去除原来标题栏
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);

        initView();
        init();
    }
    private void initView(){
        et_phonenum=(EditText)findViewById(R.id.register_phonenum);
        et_passwd=(EditText)findViewById(R.id.et_register_passwd);
        et_passwdcheck=(EditText)findViewById(R.id.et_register_passcheck);
        et_yanzheng=(EditText)findViewById(R.id.et_register_yanzheng);
        bt_yanzhengma=(Button)findViewById(R.id.bt_register_yanzhengma);
        bt_register=(Button)findViewById(R.id.bt_regist_regist);
    }
    private void init(){
        bt_register.setOnClickListener(this);
        bt_yanzhengma.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

    }
}
