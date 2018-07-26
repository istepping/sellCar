package com.car.entity;
/**
 * @author 姜志刚&张兴邦 on 2018/7/12
 * @version 1.0
 * apiNote 收藏类
 */
public class Collect {
    /** 收藏用户Id */
    private long uId;
    /** 收藏汽车Id */
    private long cId;
    public Collect(){}
    public Collect(long uId, long cId){
        this.uId = uId;
        this.cId = cId;
    }

    public long getuId() {
        return uId;
    }

    public void setuId(long uId) {
        this.uId = uId;
    }

    public long getcId() {
        return cId;
    }

    public void setcId(long cId) {
        this.cId = cId;
    }
    public String toString() {
        return "com.car.entity.Collect{" +
                " 收藏用户Id:" + this.uId +
                " 收藏汽车Id:" + this.cId +
                "}\n";
    }
}
