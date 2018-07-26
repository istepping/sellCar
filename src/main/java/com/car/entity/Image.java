package com.car.entity;

/**
 * @author 孙磊 on 2018/7/19
 * @version 1.0
 * @apiNote 车图片地址信息
 */
public class Image {
    private long cId;
    private String iUrl1;
    private String iUrl2;
    private String iUrl3;
    private String iUrl4;
    public long getcId() {
        return cId;
    }
    public void setcId(long cId) {
        this.cId = cId;
    }
    public String getiUrl1() {
        return iUrl1;
    }
    public void setiUrl1(String iUrl1) {
        this.iUrl1 = iUrl1;
    }
    public String getiUrl2() {
        return iUrl2;
    }
    public void setiUrl2(String iUrl2) {
        this.iUrl2 = iUrl2;
    }
    public String getiUrl3() {
        return iUrl3;
    }
    public void setiUrl3(String iUrl3) {
        this.iUrl3 = iUrl3;
    }
    public String getiUrl4() {
        return iUrl4;
    }
    public void setiUrl4(String iUrl4) {
        this.iUrl4 = iUrl4;
    }
    public String toString() {
        return "com.car.entity.Image{" +
                " 车Id:" + this.cId +
                " 图片1:" + this.iUrl1 +
                " 图片2："+this.iUrl2+
                " 图片3:"+this.iUrl3+
                " 图片4:"+this.iUrl4+
                "}\n";
    }
}
