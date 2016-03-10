package com.example.zhouzhongyi.kuaidi.bean;

import java.io.Serializable;

import cn.bmob.v3.BmobObject;

/**
 * Created by zhouzhongyi on 16/3/5.
 */
public class Shoppingbean extends BmobObject implements Serializable {

    private String goodsname;
    private Double goodsnumm;
    private String address;
    private String user;

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname;
    }

    public void setGoodsnumm(Double goodsnumm) {
        this.goodsnumm = goodsnumm;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getGoodsname() {

        return goodsname;
    }

    public Double getGoodsnumm() {
        return goodsnumm;
    }

    public String getAddress() {
        return address;
    }

    public String getUser() {
        return user;
    }
}
