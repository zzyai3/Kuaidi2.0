package com.example.zhouzhongyi.kuaidi.activity;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zhouzhongyi.kuaidi.Helper.ShoppingbeanHelper;
import com.example.zhouzhongyi.kuaidi.R;
import com.example.zhouzhongyi.kuaidi.adapter.Main_ViewPagerAdapter;
import com.example.zhouzhongyi.kuaidi.bean.Goodsbean;
import com.example.zhouzhongyi.kuaidi.bean.Shoppingbean;
import com.example.zhouzhongyi.kuaidi.fragment.Main_rb_1Fragment;
import com.example.zhouzhongyi.kuaidi.fragment.Main_rb_2Fragment;
import com.example.zhouzhongyi.kuaidi.fragment.Main_rb_3Fragment;
import com.example.zhouzhongyi.kuaidi.fragment.ShoppedFragment;
import com.example.zhouzhongyi.kuaidi.fragment.ShoppingFragment;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.listener.FindListener;

/**
 * Created by zhouzhongyi on 16/1/10.
 * 顾客主页面
 */
public class ShoppingActivity extends AppCompatActivity {

        private TabLayout mTabLayout1;
        private Toolbar mToolbar;
        private ActionBarDrawerToggle mDrawerToggle;
        private String[] mTitles1 = new String[]{"商品列表", "已购商品"};
        private ViewPager mViewPager1;//控制页面切换控件
        private ArrayList<Fragment> fragmentList;//需要切换的页面
        private Main_ViewPagerAdapter adapter= null;//适配器

        /**
         * ATTENTION: This was auto-generated to implement the App Indexing API.
         * See https://g.co/AppIndexing/AndroidStudio for more information.
         */
        private GoogleApiClient client;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_shopping);

            BmobUser bmobUser = BmobUser.getCurrentUser(ShoppingActivity.this);

            BmobQuery<Shoppingbean> query = new BmobQuery<Shoppingbean>();

            query.addWhereEqualTo("user", bmobUser.getObjectId());

            //执行查询方法
            query.findObjects(this, new FindListener<Shoppingbean>() {
                @Override
                public void onSuccess(List<Shoppingbean> object) {

                    for (Shoppingbean shoppingbean : object) {

                        System.err.println("-------->" + shoppingbean);

                    }



                    ShoppingbeanHelper.shoppingList = object;
                }
                @Override
                public void onError(int code, String msg) {

                }
            });
            ButterKnife.bind(this);
            mToolbar = (Toolbar) findViewById(R.id.toolbar);

//            setSupportActionBar(mToolbar);
//        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
//        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar,R.string.drawer_open,
//                R.string.drawer_close);
//        mDrawerToggle.syncState();
//        mDrawerLayout.setDrawerListener(mDrawerToggle);
//        mNavigationView = (NavigationView) findViewById(R.id.navigation_view);
//        setupDrawerContent(mNavigationView);

//            FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//            fab.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                            .setAction("Action", null).show();    }
//                //  }
//            });
            mViewPager1=(ViewPager)findViewById(R.id.id_viewpager1);
            mTabLayout1=(TabLayout)findViewById(R.id.id_tablayout1);

            mViewPager1.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
                @Override
                public Fragment getItem(int position) {

                   if
                           (position == 1) return new ShoppedFragment();

                    return new ShoppingFragment();
                }

                @Override
                public int getCount() {
                    return mTitles1.length;
                }

                @Override
                public CharSequence getPageTitle(int position) {
                    return mTitles1[position];
                }
            });

            mTabLayout1.setupWithViewPager(mViewPager1);

            //    initView();//布局中找控件
            // initSlidingMenu();//初始化侧滑菜单
            //初始化ViewPager
            // init();
            // ATTENTION: This was auto-generated to implement the App Indexing API.
            // See https://g.co/AppIndexing/AndroidStudio for more information.
            client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
        }


    @Override
    protected void onRestart() {
        super.onRestart();

        BmobUser bmobUser = BmobUser.getCurrentUser(ShoppingActivity.this);

        BmobQuery<Shoppingbean> query = new BmobQuery<Shoppingbean>();
        //查询playerName叫“比目”的数据
        query.addWhereEqualTo("user", bmobUser.getObjectId());
        //执行查询方法
        query.findObjects(this, new FindListener<Shoppingbean>() {
            @Override
            public void onSuccess(List<Shoppingbean> object) {

                for (Shoppingbean shoppingbean : object) {

                    System.err.println("-------->" + shoppingbean);




                }



                ShoppingbeanHelper.shoppingList = object;
            }
            @Override
            public void onError(int code, String msg) {

            }
        });



    }

    private void init() {
            //切换菜单点击事件

        }


        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.menu_main, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            // Handle action bar item clicks here. The action bar will
            // automatically handle clicks on the Home/Up button, so long
            // as you specify a parent activity in AndroidManifest.xml.
            int id = item.getItemId();

            //noinspection SimplifiableIfStatement
            if (id == R.id.action_settings) {
                return true;
            }

            return super.onOptionsItemSelected(item);
        }


//    @Override
//    public void onStart() {
//        super.onStart();
//
//        // ATTENTION: This was auto-generated to implement the App Indexing API.
//        // See https://g.co/AppIndexing/AndroidStudio for more information.
//        client.connect();
//        Action viewAction = Action.newAction(
//                Action.TYPE_VIEW, // TODO: choose an action type.
//                "Main Page", // TODO: Define a title for the content shown.
//                // TODO: If you have web page content that matches this app activity's content,
//                // make sure this auto-generated web page URL is correct.
//                // Otherwise, set the URL to null.
//                Uri.parse("http://host/path"),
//                // TODO: Make sure this auto-generated app deep link URI is correct.
//                Uri.parse("android-app://com.example.zhouzhongyi.kuaidi.activity/http/host/path")
//        );
////        AppIndex.AppIndexApi.start(client, viewAction);
//    }

        // @Override
//    public void onStop() {
//        super.onStop();
//
//        // ATTENTION: This was auto-generated to implement the App Indexing API.
//        // See https://g.co/AppIndexing/AndroidStudio for more information.
//        Action viewAction = Action.newAction(
//                Action.TYPE_VIEW, // TODO: choose an action type.
//                "Main Page", // TODO: Define a title for the content shown.
//                // TODO: If you have web page content that matches this app activity's content,
//                // make sure this auto-generated web page URL is correct.
//                // Otherwise, set the URL to null.
//                Uri.parse("http://host/path"),
//                // TODO: Make sure this auto-generated app deep link URI is correct.
//                Uri.parse("android-app://com.example.zhouzhongyi.kuaidi.activity/http/host/path")
//        );
////        AppIndex.AppIndexApi.end(client, viewAction);
//        client.disconnect();
//    }
    }

