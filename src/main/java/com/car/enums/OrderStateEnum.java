package com.car.enums;

/**
 * @author 孙磊 on 2018/7/15
 * @version 1.0
 * @apiNote 订单状态枚举类
 */
public enum OrderStateEnum {
    orderSuccess(1,"下单成功"),
    orderCancel(2,"已取消"),
    orderReceive(3,"已接单"),
    orderPay(4,"已付款"),
    orderSign(5,"已签收"),
    orderFinish(6,"已完成");
    //1:下单成功 2:已取消 3.已付款 4.已签收 5.已完成
    private int state;
    private String info;
    OrderStateEnum(int state, String info){
        this.state=state;
        this.info=info;
    }

    public int getState() {
        return state;
    }

    public String getInfo() {
        return info;
    }

    public String getInfoByState(int state){
        for(OrderStateEnum orderStateEnum:values()){
            if(orderStateEnum.getState()==state){
                return orderStateEnum.getInfo();
            }
        }
        return "";
    }

}
