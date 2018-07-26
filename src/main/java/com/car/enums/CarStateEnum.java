package com.car.enums;

/**
 * @author 孙磊 on 2018/7/15
 * @version 1.0
 * @apiNote 车状态枚举
 */
public enum  CarStateEnum {
    beSell(1,"正在销售"),
    offSell(2,"暂停销售"),
    beDelete(3,"已被删除");
    private int state;
    private String info;
    CarStateEnum(int state, String info){
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
