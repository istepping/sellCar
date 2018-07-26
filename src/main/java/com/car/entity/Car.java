package com.car.entity;

import java.io.Serializable;

/**
 * @author 姜志刚&张兴邦 on 2018/7/12
 * @version 1.1 更新: 新加属性cCatalog on 2018/7/14
 * @version 1.0
 * apiNote 车辆类
 */
public class Car implements Serializable {
    private static final long serialVersionUID = 2912164127598660137L;
    /** 汽车id */
    private long cId;
    /** 汽车品牌 */
    private String cBrand;
    /** 汽车颜色 */
    private String cColor;
    /** 汽车参考价 */
    private String cPrice;
    /** 汽车库存 */
    private int cNum;
    /** 汽车图片所在网址 */
    private String cUrl;
    /** 汽车状态 */
    private int cState;
    /**车类型*/
    private String cCatalog;
    public  Car(){}
    public  Car(long cId, String cBrand, String cColor, String cPrice, int cNum, String cUrl, int cState,String cCatalog){
        this.cId = cId;
        this.cBrand = cBrand;
        this.cColor = cColor;
        this.cPrice = cPrice;
        this.cNum = cNum;
        this.cUrl = cUrl;
        this.cState = cState;
        this.cCatalog=cCatalog;
    }
    public Car(String cBrand, String cColor, String cPrice, int cNum,String cCatalog,int cState){
        this.cBrand = cBrand;
        this.cColor = cColor;
        this.cPrice = cPrice;
        this.cNum = cNum;
        this.cState = cState;
        this.cCatalog=cCatalog;
    }


    public long getcId() {
        return cId;
    }

    public void setcId(long cId) {
        this.cId = cId;
    }

    public String getcBrand() {
        return cBrand;
    }

    public void setcBrand(String cBrand) {
        this.cBrand = cBrand;
    }

    public String getcColor() {
        return cColor;
    }

    public void setcColor(String cColor) {
        this.cColor = cColor;
    }

    public String getcPrice() {
        return cPrice;
    }

    public void setcPrice(String cPrice) {
        this.cPrice = cPrice;
    }

    public int getcNum() {
        return cNum;
    }

    public void setcNum(int cNum) {
        this.cNum = cNum;
    }

    public String getcUrl() {
        return cUrl;
    }

    public void setcUrl(String cUrl) {
        this.cUrl = cUrl;
    }

    public int getcState() {
        return cState;
    }

    public void setcState(int cState) {
        this.cState = cState;
    }

    public String getcCatalog() {
        return cCatalog;
    }

    public void setcCatalog(String cCatalog) {
        this.cCatalog = cCatalog;
    }

    @Override
    public String toString() {
        return
                " 汽车Id:"+this.getcId()+
                " 汽车品牌:"+this.getcBrand()+
                " 汽车颜色:"+this.getcColor()+
                " 汽车参考价:"+this.getcPrice()+
                " 汽车库存:"+this.getcNum()+
                " 汽车图片所在网址:"+this.getcUrl()+
                " 汽车状态:"+this.getcState()+
                " 汽车类型:"+this.getcCatalog();
    }
}

