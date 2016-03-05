package com.example.zhouzhongyi.kuaidi.bean;

import cn.bmob.v3.BmobObject;

/**
 * Created by zhouzhongyi on 16/3/5.
 */
public class Goodsbean extends BmobObject{
    private String goodsname;
    private Double goodsnum;
    private Double goodsprice;

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname;
    }

    public void setGoodsnum(Double goodsnum) {
        this.goodsnum = goodsnum;
    }

    public void setGoodsprice(Double goodsprice) {
        this.goodsprice = goodsprice;
    }

    public String getGoodsname() {

        return goodsname;
    }

    public Double getGoodsnum() {
        return goodsnum;
    }

    public Double getGoodsprice() {
        return goodsprice;
    }

    public Goodsbean() {

    }
}
