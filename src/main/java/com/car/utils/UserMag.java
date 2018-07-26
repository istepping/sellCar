package com.car.utils;

import com.car.entity.User;

import java.util.Date;

/**
 * @author 孙磊 on 2018/7/15
 * @version 1.0
 * @apiNote 用户登陆管理
 */
public class UserMag {
    /**用户*/
    private User user;
    /**登陆时间*/
    Date loginTime;
    /**登陆状态*/
    private int loginState;
    public UserMag(){}
    public UserMag(User user,Date loginTime,int loginState){
        this.user=user;
        this.loginTime=loginTime;
        this.loginState=loginState;
    }
    public User getUser() {
        return user;
    }
    public Date getLoginTime() {
        return loginTime;
    }
    public int getLoginState() {
        return loginState;
    }
    public void setLoginState(int loginState) {
        this.loginState = loginState;
    }
}
