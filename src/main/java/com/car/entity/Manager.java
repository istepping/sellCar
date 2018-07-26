package com.car.entity;

/**
 * @author 姜志刚&张兴邦 on 2018/7/12
 * @version 1.0
 * apiNote 管理员类
 */
public class Manager {
    /** 管理员id */
    private long mId;
    /** 管理员姓名 */
    private String mName;
    /** 管理员密码 */
    private String mPassword;
    /** 管理员权限 */
    private int mAuthority;
    public  Manager(){}
    public  Manager(long mId, String mName, String mPassword, int mAuthority){
        this.mId = mId;
        this.mName = mName;
        this.mPassword = mPassword;
        this.mAuthority = mAuthority;
    }

    public long getmId() {
        return mId;
    }

    public void setmId(long mId) {
        this.mId = mId;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmPassword() {
        return mPassword;
    }

    public void setmPassword(String mPassword) {
        this.mPassword = mPassword;
    }

    public int getmAuthority() {
        return mAuthority;
    }

    public void setmAuthority(int mOrderaty) {
        this.mAuthority = mOrderaty;
    }
    public String toString(){
        return "com.car.entity.Manager{"+
                " 管理员Id:"+this.mId+
                " 管理员姓名:"+this.mName+
                " 管理员密码:"+this.mPassword+
                " 管理员权限:"+this.mAuthority+
                "}\n";
    }
}

