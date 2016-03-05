package com.example.zhouzhongyi.kuaidi.bean;

import cn.bmob.v3.BmobUser;

/**
 * Created by zhouzhongyi on 16/3/5.
 */
public class UserData extends BmobUser {
    private static final long serialVersionUID = 1L;
    private int usertype;

    public int getUsertype() {
        return usertype;
    }

    public UserData() {
    }

    public UserData(int usertype) {
        this.usertype = usertype;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public void setUsertype(int usertype) {
        this.usertype = usertype;
    }
}
