package com.car.enums;

/**
 * @author 孙磊 on 2018/7/16
 * @version 1.0
 * @apiNote 管理员权限
 */
public enum ManagerAuthorityEnum {
    lowAuthority(1,"低级权限"),
    middleAuthority(2,"中级权限"),
    topAuthority(3,"顶级权限");
    private int authority;
    private String info;
    ManagerAuthorityEnum(int authority, String info){
        this.authority=authority;
        this.info=info;
    }
    public int getAuthority() {
        return authority;
    }
    public String getInfo() {
        return info;
    }
}
