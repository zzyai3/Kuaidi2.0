package com.example.zhouzhongyi.kuaidi.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.zhouzhongyi.kuaidi.R;
import com.example.zhouzhongyi.kuaidi.bean.UserData;

import butterknife.ButterKnife;
import cn.bmob.v3.listener.SaveListener;

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
    private RadioGroup rg;
    private RadioButton r_shopping_button;
    private RadioButton r_song_button;
   // private CheckButtonHelper helper;//验证码倒计时
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//去除原来标题栏
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
//        bt_yanzhengma.setOnClickListener(new View.OnClickListener() {

//            @Override
//            public void onClick(View arg0) {
//
//                CountDownButtonHelper helpe = new CountDownButtonHelper(bt_yanzhengma,
//                        "发送验证码", 60, 1);
//                helpe.setOnFinishListener(new CountDownButtonHelper.OnFinishListener() {
//
//                    @Override
//                    public void finish() {
//                        Toast.makeText(RegisterActicity.this, "倒计时结束",
//                                Toast.LENGTH_SHORT).show();
//                    }
//                });
//                helpe.start();
//
//            }
//        });

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
        rg=(RadioGroup)findViewById(R.id.rg);

        r_shopping_button=(RadioButton)findViewById(R.id.r_shopping_button);
        r_song_button=(RadioButton)findViewById(R.id.r_song_button);
    }
    private void init(){
        bt_register.setOnClickListener(this);
        bt_yanzhengma.setOnClickListener(this);


    }
    public void register(){
        String userPhone=this.et_phonenum.getText().toString().trim();
        String password=this.et_passwd.getText().toString().trim();
        UserData userData = new UserData();
        userData.setUsername(userPhone);
        userData.setPassword(password);
        Integer type = null;

        if (rg.getCheckedRadioButtonId() == R.id.r_shopping_button) {
            type=1;
        } else if (rg.getCheckedRadioButtonId() == R.id.r_song_button){
            type=2;
        }

        userData.setUsertype(type);

        userData.signUp(this, new SaveListener() {
            @Override
            public void onSuccess() {
                Intent intent =new Intent(RegisterActicity.this,LoginActivity.class);
                startActivity(intent);
                finish();
            }
            @Override
            public void onFailure(int i, String s) {
                Toast.makeText(RegisterActicity.this,"服务器繁忙",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_register_yanzhengma:
                String phone = et_phonenum.getText().toString();
                //初始化
                cn.smssdk.SMSSDK.initSDK(this, "f82970592038", "e1a79f6f1320a0fbe2c7cc04f068d8d3");
                //发送短信
                cn.smssdk.SMSSDK.getVerificationCode("86",phone);
                break;
            case R.id.bt_regist_regist:
                register();
                break;
        }


    }
}
