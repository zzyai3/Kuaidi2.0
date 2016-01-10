package com.example.zhouzhongyi.kuaidi.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by HM on 2015/9/7.
 * 订单中心Fragment适配器
 */
public class Center_FragmentAdapter extends FragmentPagerAdapter {
    ArrayList<Fragment> list = new ArrayList<Fragment>();
    FragmentManager fm;
    Context context;
    private int mChildCount = 0;
    public Center_FragmentAdapter(FragmentManager fm, ArrayList<Fragment> list) {
        super(fm);
        this.list = list;
        this.fm = fm;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    //更新ViewPager里的item的数据 必须重写方法
    @Override
    public void notifyDataSetChanged() {
        mChildCount = getCount();
        super.notifyDataSetChanged();
    }
    @Override
    public int getItemPosition(Object object)   {
        if ( mChildCount > 0) {
            mChildCount --;
            return POSITION_NONE;
        }
        return super.getItemPosition(object);
    }
    //更新ViewPager里的item的数据 必须重写方法结束
}
