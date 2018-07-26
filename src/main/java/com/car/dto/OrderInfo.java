package com.car.dto;

import java.util.Date;

/**
 * @author 姜志刚&张兴邦 on 2018/7/20
 * @version 1.0
 * apiNote 订单类
 */

public class OrderInfo {
    /**订单号*/
    private long oId;
    /** 顾客姓名 */
    private String uName;
    /** 顾客的电话号码 */
    private String uPhone;
    /** 顾客的家庭住址 */
    private String uAddress;
    /** 汽车id */
    private long cId;
    /** 汽车品牌 */
    private String cBrand;
    /**订单时间*/
    private Date oTime;
    /** 汽车参考价 */
    private String cPrice;
    /**订单状态*/
    private int oState;
    /**订单状态信息*/
    private String oStateInfo;
    /**构造函数*/
    public OrderInfo(){}
    public OrderInfo(long oId,String uName,String uPhone,String uAddress,long cId,String cBrand,Date oTime,String cPrice,int oState,String oStateInfo){
        this.oId = oId;
        this.uName=uName;
        this.uPhone=uPhone;
        this.uAddress=uAddress;
        this.cId = cId;
        this.cBrand=cBrand;
        this.oTime = oTime;
        this.cPrice=cPrice;
        this.oState = oState;
        this.oStateInfo=oStateInfo;
    }
    /**获取订单id*/
    public long getoId() {
        return oId;
    }
    /**设置订单id*/
    public void setoId(long oId) {
        this.oId = oId;
    }
    /** 获取顾客姓名*/
    public String getuName() {
        return uName;
    }
    /** 设置顾客id*/
    public void setuName(String uName) {
        this.uName = uName;
    }
    /** 获取顾客电话号码*/
    public String getuPhone() {
        return uPhone;
    }
    /** 获取顾客设置顾客电话号码*/
    public void setuPhone(String uPhone) {
        this.uPhone = uPhone;
    }
    /** 获取顾客地址*/
    public String getuAddress() {
        return uAddress;
    }
    /** 获取顾客地址*/
    public void setuAddress(String uAddress) {
        this.uAddress = uAddress;
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
    /**获取订单时间*/
    public Date getoTime() {
        return oTime;
    }
    /**设置订单时间*/
    public void setoTime(Date oTime) { this.oTime = oTime; }
    /**获取订单状态*/

    public String getcPrice() {
        return cPrice;
    }

    public void setcPrice(String cPrice) {
        this.cPrice = cPrice;
    }

    public int getoState() { return oState; }
    /**设置订单状态*/
    public void setoState(int oState) { this.oState = oState; }

    public String getoStateInfo() { return oStateInfo; }
    /**设置订单状态*/
    public void setoStateInfo(String oStateInfo) { this.oStateInfo = oStateInfo; }
    @Override
    public String toString() {
        return "com.car.Order:"+
                " 订单ID:"+oId+
                "用户名:"+uName+
                "用户电话:"+uPhone+
                "用户地址:"+uAddress+
                " 车辆ID:"+cId+
                " 车辆品牌:"+cBrand+
                " 订单时间:"+oTime+
                "订单价格"+cPrice+
                " 订单状态:"+oState;
    }
}
