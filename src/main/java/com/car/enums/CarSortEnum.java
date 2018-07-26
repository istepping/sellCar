package com.car.enums;

/**
 * @author 孙磊 on 2018/7/15
 * @version 1.0
 * @apiNote 车类别
 */
public enum CarSortEnum {
    SUV("SUV","多功能越野车"),
    NEV("NEV","新能源"),
    sportCar("sportCar","跑车");
    private String sort;
    private String info;
    CarSortEnum(String sort,String info){
        this.sort=sort;
        this.info=info;
    }
    public String getSort() {
        return sort;
    }
    public String getInfo() {
        return info;
    }
}
