package com.example.zhouzhongyi.kuaidi.bean;

import cn.bmob.v3.BmobObject;

/**
 * Created by zhouzhongyi on 16/3/5.
 */
public class Goodsbean extends BmobObject{
    private String goodsname;
    private String goodsnum;
    private String goodsprice;

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname;
    }

    public void setGoodsnum(String goodsnum) {
        this.goodsnum = goodsnum;
    }

    public void setGoodsprice(String goodsprice) {
        this.goodsprice = goodsprice;
    }

    public String getGoodsname() {
        return goodsname;
    }

    public String getGoodsnum() {
        return goodsnum;
    }

    public String getGoodsprice() {
        return goodsprice;
    }
}
