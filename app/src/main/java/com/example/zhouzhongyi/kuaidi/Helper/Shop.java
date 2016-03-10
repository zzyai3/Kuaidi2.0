package com.example.zhouzhongyi.kuaidi.Helper;

import java.io.Serializable;

/**
 * Created by zhouzhongyi on 16/3/9.
 */
public class Shop  implements Serializable {
    private String goodsname;
    private String goodsprice;
    private int photoId;





    public Shop(String name, String price, int photoId) {
        this.goodsname=name;
        this.goodsprice=price;
        this.photoId=photoId;

    }
    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname;
    }

    public void setGoodsprice(String goodsprice) {
        this.goodsprice = goodsprice;
    }

    public void setPhotoId(int photoId) {
        this.photoId = photoId;
    }
    public String getGoodsname() {
        return goodsname;
    }

    public String getGoodsprice() {
        return goodsprice;
    }

    public int getPhotoId() {
        return photoId;
    }

}
