package com.example.zhouzhongyi.kuaidi.activity;

import android.graphics.Bitmap;
import android.net.Uri;
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
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.example.zhouzhongyi.kuaidi.Helper.Helper;
import com.example.zhouzhongyi.kuaidi.R;
import com.example.zhouzhongyi.kuaidi.adapter.Center_FragmentAdapter;
import com.example.zhouzhongyi.kuaidi.adapter.Main_ViewPagerAdapter;

import com.example.zhouzhongyi.kuaidi.bean.Shoppingbean;
import com.example.zhouzhongyi.kuaidi.bean.UserData;
import com.example.zhouzhongyi.kuaidi.fragment.Main_rb_1Fragment;
import com.example.zhouzhongyi.kuaidi.fragment.Main_rb_2Fragment;
import com.example.zhouzhongyi.kuaidi.fragment.Main_rb_3Fragment;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.GetListener;

public class MainActivity extends AppCompatActivity {
    private TabLayout mTabLayout;
    private DrawerLayout mDrawerLayout;
 //   private BackHandledFragment selectedFragment;
    private NavigationView mNavigationView;
    private Toolbar mToolbar;

    private ActionBarDrawerToggle mDrawerToggle;
    private String[] mTitles = new String[]{"未接单", "进行中", "已完成"};
    private ViewPager mViewPager;//控制页面切换控件
    private ArrayList<Fragment> fragmentList;//需要切换的页面
    private Main_ViewPagerAdapter adapter = null;//适配器

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //查询1
        BmobQuery<Shoppingbean> query = new BmobQuery<Shoppingbean>();
        query.addWhereEqualTo("type", "1");
        //执行查询方法
        query.findObjects(this, new FindListener<Shoppingbean>() {
            @Override
            public void onSuccess(List<Shoppingbean> object) {
                for (final Shoppingbean shoppingbean : object) {
                    BmobQuery<UserData> query = new BmobQuery<UserData>();
                    query.getObject(MainActivity.this, shoppingbean.getUser(), new GetListener<UserData>() {
                        @Override
                        public void onSuccess(UserData object) {
                            shoppingbean.setPhone(object.getUsername());
                        }
                        @Override
                        public void onFailure(int code, String arg0) {

                        }
                    });
                }
                Helper.orderList1 = object;
            }
            @Override
            public void onError(int code, String msg) {

            }
        });
        //查询2
        BmobQuery<Shoppingbean> query2 = new BmobQuery<Shoppingbean>();
        BmobUser bmobUser = BmobUser.getCurrentUser(MainActivity.this);
        query2.addWhereEqualTo("type", "2");
        query2.addWhereEqualTo("usersong", bmobUser.getObjectId());
        //执行查询方法
        query2.findObjects(this, new FindListener<Shoppingbean>() {
            @Override
            public void onSuccess(List<Shoppingbean> object) {
                for (final Shoppingbean shoppingbean : object) {
                    BmobQuery<UserData> query = new BmobQuery<UserData>();
                    query.getObject(MainActivity.this, shoppingbean.getUser(), new GetListener<UserData>() {
                        @Override
                        public void onSuccess(UserData object) {
                            shoppingbean.setPhone(object.getUsername());
                        }
                        @Override
                        public void onFailure(int code, String arg0) {

                        }
                    });
                }
                Helper.orderList2 = object;
            }
            @Override
            public void onError(int code, String msg) {

            }
        });
        //查询3
        BmobQuery<Shoppingbean> query3 = new BmobQuery<Shoppingbean>();
        query3.addWhereEqualTo("type", "3");
        //执行查询方法
        query3.findObjects(this, new FindListener<Shoppingbean>() {
            @Override
            public void onSuccess(List<Shoppingbean> object) {for (final Shoppingbean shoppingbean : object) {
                BmobQuery<UserData> query = new BmobQuery<UserData>();
                query.getObject(MainActivity.this, shoppingbean.getUser(), new GetListener<UserData>() {
                    @Override
                    public void onSuccess(UserData object) {
                        shoppingbean.setPhone(object.getUsername());
                    }
                    @Override
                    public void onFailure(int code, String arg0) {

                    }
                });
            }

                Helper.orderList3 = object;
            }
            @Override
            public void onError(int code, String msg) {

            }
        });


        ButterKnife.bind(this);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);


//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();    }
//            //  }
//        });
                mViewPager=(ViewPager)findViewById(R.id.id_viewpager);
                mTabLayout=(TabLayout)findViewById(R.id.id_tablayout);

                mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
                    @Override
                    public Fragment getItem(int position) {

                        if (position == 1) return new Main_rb_2Fragment();
                        if (position == 2) return new Main_rb_3Fragment();
                        return new Main_rb_1Fragment();



                    }

                    @Override
                    public int getCount() {
                        return mTitles.length;
                    }

                    @Override
                    public CharSequence getPageTitle(int position) {
                        return mTitles[position];
                    }
                });

                mTabLayout.setupWithViewPager(mViewPager);




        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
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

    /**
     * 调用onCreate(), 目的是刷新数据,
     * 从另一activity界面返回到该activity界面时, 此方法自动调用
     */
//    @Override
//    protected void onResume() {
//        super.onResume();
//        onCreate(null);
//    }
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
