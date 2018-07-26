package com.car.entity;

/**
 * @author 黄伟&杨圳达 on 2018/7/12
 * @version 1.0
 * @apiNote 用户类
 */
public class User {
    /** 顾客id用于顾客登陆本系统*/
    private long uId;
    /** 顾客姓名 */
    private String uName;
    /** 顾客登陆系统使用的密码 */
    private String uPassword;
    /** 顾客的电话号码 */
    private String uPhone;
    /** 顾客的家庭住址 */
    private String uAddress;
    /**账户状态*/
    private int uState;
    /** 构造函数*/
    public User(){}
    public User(long uId,String uName,String uPassword,String uPhone,String uAddress,int uState){
        this.uId = uId;
        this.uName = uName;
        this.uPassword = uPassword;
        this.uPhone = uPhone;
        this.uAddress = uAddress;
        this.uState=uState;
    }
    /** 顾客用来查看顾客的订单信息 */
    public void lookOrder() {
        // TODO: implement
    }
    /** 获取顾客id*/
    public long getuId() {
        return uId;
    }
    /** 设置顾客id*/
    public void setuId(long uId) {
        this.uId = uId;
    }
    /** 获取顾客姓名*/
    public String getuName() {
        return uName;
    }
    /** 设置顾客id*/
    public void setuName(String uName) {
        this.uName = uName;
    }
    /** 获取顾客密码*/
    public String getuPassword() {
        return uPassword;
    }
    /** 获取顾客设置*/
    public void setuPassword(String uPassword) {
        this.uPassword = uPassword;
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

    public int getuState() {
        return uState;
    }

    public void setuState(int uState) {
        this.uState = uState;
    }

    /**用于输出顾客信息*/
     public String toString(){
        return  " 顾客id是:"+this.uId+
                " 顾客姓名是:"+this.uName+
                " 用户密码是:"+this.uPassword+
                " 用户电话是:"+this.uPhone+
                " 用户住址:"+this.uAddress+
                " 账户状态:"+uState;
     }

}