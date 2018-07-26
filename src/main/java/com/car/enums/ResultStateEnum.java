package com.car.enums;

/**
 * @author 孙磊 on 2018/7/19
 * @version 1.0
 * @apiNote 服务执行状态枚举类
 */
public enum ResultStateEnum {
     //1.执行成功 -1.输入错误 -2.未登陆 -3.数据库异常
    serviceSuccess(1,"执行成功"),
    inputError(-1,"输入错误"),
    logingError(-2,"未登陆"),
    dataBaseError(-3,"数据库异常"),
    authorityError(-4,"权限异常");
    private int state;
    private String info;
    ResultStateEnum(int state, String info){
        this.state=state;
        this.info=info;
    }
    public int getState() {
        return state;
    }
    public String getInfo() {
        return info;
    }
}
