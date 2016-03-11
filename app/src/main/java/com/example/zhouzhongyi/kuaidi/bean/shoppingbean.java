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
    private String type;
    private String usersong;
    private String phone;

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {

        return phone;
    }

    public String getType() {
        return type;
    }

    public String getUsersong() {
        return usersong;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setUsersong(String usersong) {
        this.usersong = usersong;
    }

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
