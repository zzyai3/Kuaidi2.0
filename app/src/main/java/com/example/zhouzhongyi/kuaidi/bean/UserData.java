package com.example.zhouzhongyi.kuaidi.bean;

import cn.bmob.v3.BmobUser;

/**
 * Created by zhouzhongyi on 16/3/5.
 */
public class UserData extends BmobUser {
    private static final long serialVersionUID = 1L;
    private String userPersonName;
    private int usertype;
    private String userPassword;

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserPassword() {

        return userPassword;
    }

    public void setUsertype(int usertype) {
        this.usertype = usertype;
    }

    public int getUsertype() {

        return usertype;
    }

    public UserData(int usertype) {

        this.usertype = usertype;
    }

    public UserData() {};

    public UserData(String userPersonName) {
        this.userPersonName = userPersonName;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getUserPersonName() {
        return userPersonName;
    }

    public void setUserPersonName(String userPersonName) {
        this.userPersonName = userPersonName;
    }
}
