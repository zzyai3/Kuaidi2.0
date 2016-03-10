package com.example.zhouzhongyi.kuaidi.bean;

import java.io.Serializable;

import cn.bmob.v3.BmobObject;

/**
 * Created by zhouzhongyi on 16/3/5.
 */
public class Goodsbean extends BmobObject implements Serializable {
    private String goodsname;
    private Double goodsnum;
    private String goodsprice;

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname;
    }

    public void setGoodsnum(Double goodsnum) {
        this.goodsnum = goodsnum;
    }

    public void setGoodsprice(String goodsprice) {
        this.goodsprice = goodsprice;
    }

    public String getGoodsname() {

        return goodsname;
    }

    public Double getGoodsnum() {
        return goodsnum;
    }

    public String getGoodsprice() {
        return goodsprice;
    }
}
