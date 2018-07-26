package com.car.enums;

/**
 * @author 孙磊 on 2018/7/15
 * @version 1.0
 * @apiNote 用户登陆状态枚举类
 */
public enum  LoginStateEnum {
    beOnLine(1,"正在线"),
    beOffLine(2,"已离线");
    private int state;
    private String info;
    LoginStateEnum(int state, String info){
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
