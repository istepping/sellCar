package com.car.enums;

/**
 * @author 孙磊 on 2018/7/15
 * @version 1.0
 * @apiNote 用户账号状态
 */
public enum UserStateEnum {
    offLine(1,"离线"),
    onLine(2,"在线"),
    nonCount(3,"用户不存在");
    private int state;
    private String info;
    UserStateEnum(int state, String info){
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
