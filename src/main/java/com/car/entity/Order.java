package com.car.entity;

import java.util.*;
import java.sql.Timestamp;
/**
 * @author 黄伟&杨圳达on 2018/7/12
 * @version 1.1
 * @apiNote 订单类
 */
public class Order {
    /**订单号*/
    private long oId;
    /**订单车辆ID*/
    private long cId;
    /**订单用户ID*/
    private long uId;
    /**订单时间*/
    private Timestamp oTime;
    /**订单状态*/
    private int oState;
    /**构造函数*/
    Order(){}
    Order(long oId,long cId,long uId,Timestamp oTime,int oState){
        this.oId = oId;
        this.cId = cId;
        this.uId = uId;
        this.oTime = oTime;
        this.oState = oState;
    }
    /**获取订单id*/
    public long getoId() {
        return oId;
    }
    /**设置订单id*/
    public void setoId(long oId) {
        this.oId = oId;
    }
    /**获取订单时间*/
    public Date getoTime() {
        return oTime;
    }
    /**设置订单时间*/
    public void setoTime(Timestamp oTime) {
        this.oTime = oTime;
    }
    /**获取订单状态*/
    public int getoState() {
        return oState;
    }
    /**设置订单状态*/
    public void setoState(int oState) {
        this.oState = oState;
    }
    public long getcId() {
        return cId;
    }
    public void setcId(long cId) {
        this.cId = cId;
    }
    public long getuId() {
        return uId;
    }
    public void setuId(long uId) {
        this.uId = uId;
    }

    @Override
    public String toString() {
        return "com.car.Order:"+
                " 订单ID:"+oId+
                " 车辆ID:"+cId+
                " 用户ID:"+uId+
                " 订单时间:"+oTime+
                " 订单状态:"+oState;
    }
}

