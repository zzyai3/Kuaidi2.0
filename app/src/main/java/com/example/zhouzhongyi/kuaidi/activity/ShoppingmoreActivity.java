package com.example.zhouzhongyi.kuaidi.activity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zhouzhongyi.kuaidi.R;
import com.example.zhouzhongyi.kuaidi.bean.Goodsbean;
import com.example.zhouzhongyi.kuaidi.bean.Shoppingbean;

import butterknife.ButterKnife;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.listener.UpdateListener;

/**
 * Created by zhouzhongyi on 16/2/19.
 * 下单页面
 */
public class ShoppingmoreActivity extends AppCompatActivity {
    private TextView tv_shopid;
    private Button bt_check;
    private TextView tv_shopid1;
    private EditText et_number;
    private EditText et_addrees;
    private TextView tv_price1;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoppingmore);
        tv_shopid1 = (TextView)findViewById(R.id.tv_goodsname);
        tv_price1 = (TextView)findViewById(R.id.tv_price1);
        et_number = (EditText)findViewById(R.id.et_number);
        et_addrees = (EditText) findViewById(R.id.et_address);


       //ButterKnife.bind(this);
        bt_check = (Button)findViewById(R.id.bt_check);
        Intent intent = getIntent();

        final Goodsbean item= (Goodsbean) intent.getSerializableExtra("Shop");
      //  newsPhoto.setImageResource(item.getPhotoId());

        tv_shopid1.setText(item.getGoodsname());
       tv_price1.setText(item.getGoodsprice());



        bt_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Double number = Double.parseDouble(et_number.getText().toString());
                String address = et_addrees.getText().toString().trim();
                Toast.makeText(ShoppingmoreActivity.this,"number"+number+address,Toast.LENGTH_LONG).show();
                //更新库存
                item.setGoodsnum(item.getGoodsnum() - number);
                item.update(ShoppingmoreActivity.this, item.getObjectId(), new UpdateListener() {
                    @Override
                    public void onSuccess() {
                        Log.i("bmob","更新成功：");
                    }

                    @Override
                    public void onFailure(int code, String msg) {
                        Log.i("bmob","更新失败："+msg);
                    }
                });
                //添加订单
                BmobUser bmobUser = BmobUser.getCurrentUser(ShoppingmoreActivity.this);
                Shoppingbean sb = new Shoppingbean();
                sb.setUser(bmobUser.getObjectId());
                sb.setGoodsname(item.getGoodsname());
                sb.setAddress(address);
                sb.setGoodsnumm(number);
                sb.setType("1");
                sb.save(ShoppingmoreActivity.this, new SaveListener() {
                    @Override
                    public void onSuccess() {
                        Toast.makeText(ShoppingmoreActivity.this,"成功,请查看数据库",Toast.LENGTH_SHORT).show();
                    }
                    @Override
                    public void onFailure(int code, String arg0) {
                        // 添加失败
                    }
                });






                Intent intent = new Intent();
                intent.setClass(ShoppingmoreActivity.this, CheckdoneActivity.class);
                ShoppingmoreActivity.this.startActivity(intent);
            }
        });



    }
}
