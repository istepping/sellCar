package com.car.utils;

import com.car.entity.Manager;

import java.util.Date;

/**
 * @author 孙磊 on 2018/7/15
 * @version 1.0
 * @apiNote 管理员登陆管理
 */
public class ManagerMag {
    /**管理员*/
    Manager manager;
    /**登陆时间*/
    Date loginTime;
    public ManagerMag(){}
    public ManagerMag(Manager manager,Date loginTime){
        this.manager=manager;
        this.loginTime=loginTime;
    }

    public Manager getManager() {
        return manager;
    }

    public Date getLoginTime() {
        return loginTime;
    }
}
