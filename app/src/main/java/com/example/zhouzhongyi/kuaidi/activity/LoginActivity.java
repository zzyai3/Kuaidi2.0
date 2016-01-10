package com.example.zhouzhongyi.kuaidi.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zhouzhongyi.kuaidi.R;

import butterknife.ButterKnife;

/**
 * Created by zhouzhongyi on 15/12/24.
 */
public class LoginActivity extends Activity {
    private EditText et_lg_phonenum;
    private EditText et_lg_passwd;
    private Button btn_lg_regster;
    private Button btn_lg_login;
    private RadioGroup mRadioGroup;
    private RadioButton shopbutton,songbutton;
  //  private ToastUtils toast = new ToastUtils(this);//初始化Toast工具类
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//去除原来标题栏
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
       et_lg_phonenum=(EditText)findViewById(R.id.et_lg_phonenum);
       et_lg_passwd=(EditText)findViewById(R.id.et_lg_passwd);
       btn_lg_regster=(Button)findViewById(R.id.btn_lg_register);
       btn_lg_login=(Button)findViewById(R.id.btn_lg_login);
        mRadioGroup=(RadioGroup)findViewById(R.id.ttt);
        shopbutton=(RadioButton)findViewById(R.id.shopping_button);
        songbutton=(RadioButton)findViewById(R.id.song_button);
        btn_lg_login.setOnClickListener(new View.OnClickListener() {

                                     @Override
                                     public void onClick(View arg0) {
                                         // 用户名和密码不能为空
                                         String name = et_lg_phonenum.getText()
                                                 .toString();
                                         String password = et_lg_passwd.getText()
                                                 .toString();
                                         if (!name.equals("")) {
                                             if (!password.equals("")) {
                                                  if (shopbutton.isChecked()) {
                                                 Intent intent = new Intent();
                                                 intent.setClass(LoginActivity.this, ShoppingActivity.class);
                                                 LoginActivity.this.startActivity(intent);
                                                   }else {if (songbutton.isChecked()){
                                                      Intent intent = new Intent();
                                                      intent.setClass(LoginActivity.this, MainActivity.class);
                                                      LoginActivity.this.startActivity(intent);
                                                  }

                                                  }
                                                 //   else{
                                                 //       Toast.makeText(LoginActivity.this, "请同意协议",
                                                 //             Toast.LENGTH_SHORT).show();
                                                 //   }
                                             } else {
                                                 Toast.makeText(LoginActivity.this, "请输入密码",
                                                         Toast.LENGTH_SHORT).show();
                                             }
                                         } else {
                                             Toast.makeText(LoginActivity.this, "请输入用户名",
                                                     Toast.LENGTH_SHORT).show();
                                         }
                                     }
                                 }

        );
        btn_lg_regster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent();

                intent.setClass(LoginActivity.this, RegisterActicity.class);
                LoginActivity.this.startActivity(intent);
            }
        });


//        initView();
//        init();
    }

//    private void initView(){
//        et_lg_phonenum=(EditText)findViewById(R.id.et_lg_phonenum);
//        et_lg_passwd=(EditText)findViewById(R.id.et_lg_passwd);
//        btn_lg_regster=(Button)findViewById(R.id.btn_lg_register);
//        btn_lg_login=(Button)findViewById(R.id.btn_lg_login);
//
//    }
//    private void init(){
//        et_lg_phonenum.addTextChangedListener(this);
//
////        //用户名edittext软键盘enter键响应事件
////        et_lg_phonenum.setOnEditorActionListener(this);
////        et_lg_phonenum.setImeOptions(EditorInfo.IME_ACTION_NEXT);//替换enter外观 使外观变成“下一项”
////        //密码edittext软键盘enter键响应事件
////        et_lg_passwd.setOnEditorActionListener(this);
////        et_lg_passwd.setImeOptions(EditorInfo.IME_ACTION_DONE);//替换enter外观 使外观变成“完成”
//
//        //登录按钮响应事件
//        btn_lg_login.setOnClickListener(this);
//        //注册按钮响应事件
//        btn_lg_regster.setOnClickListener(this);
//
//    }
//    //按钮响应事件
//
//    public void onClick(View v) {
//        switch (v.getId()){
//            //登录
//            case R.id.btn_lg_login:
//                Login();//调用登录方法
//                break;
//            //注册
//            case R.id.bt_regist_regist:
//                startActivity(new Intent(LoginActivity.this,RegisterActicity.class));
//                break;
//        }
//    }
//    //登录按钮方法
//    public void Login(){
//        String user_name = et_lg_phonenum.getText().toString();//取出输入字符串
//        String user_passwd = et_lg_passwd.getText().toString();//取出输入字符串
//        //判断用户密码是否为空
//        if ("".equals(user_name.trim())||null==user_name){
//            toast.showShort("用户名不能为空");
//            return;
//        }
//        if ("".equals(user_passwd.trim())||null==user_passwd){
//            toast.showShort("密码不能为空");
//            return;
//        }
//        //传入用户名，密码。访问网络。
//        getLogin(user_name, user_passwd);
//    }
//    //软键盘enter 事件
//    @Override
//    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
//        switch (v.getId()){
//            //软键盘enter 用户名
//            case R.id.et_lg_phonenum:
//                //判断触摸enter键
//                if (actionId == EditorInfo.IME_ACTION_NEXT ||
//                        (event != null && event.getKeyCode() == KeyEvent.KEYCODE_ENTER)) {
//                    //让密码输入框获取输入焦点
//                    et_lg_passwd.requestFocus();
//                    return true;
//                }
//                break;
//            //软键盘enter 密码
//            case R.id.et_lg_passwd:
//                //判断点击enter键
//                if (actionId == EditorInfo.IME_ACTION_DONE ||
//                        (event != null && event.getKeyCode() == KeyEvent.KEYCODE_ENTER)) {
//                    //关闭软键盘
//                    InputMethodManager imm = (InputMethodManager)
//                            getSystemService(Context.INPUT_METHOD_SERVICE);
//                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
//                    return true;
//                }
//                break;
//        }
//        return false;
//    }

}