package com.car.utils;

import com.car.entity.Manager;
import com.car.entity.User;
import com.car.enums.LoginStateEnum;
import static com.car.utils.StaticMethod.logger;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 孙磊 on 2018/7/15
 * @version 1.0
 * @apiNote 所有用户登陆管理
 */
public class LoginMag {
    public static final long legal_time=60*30*1000;
    /**全部登陆信息缓冲区:String 键 User 登陆用户信息*/
    public static Map<String,UserMag> userLoginMagMap=new HashMap<>();
    /**全部登陆信息缓冲区:String 键 manager 登陆用户信息*/
    public static Map<String,ManagerMag> managerLoginMagMap=new HashMap<>();
    /**
     * @author 孙磊 on 2018/7/15
     * @apiNote 登陆状态检测 static 方法
     * @param  uId 用户id
     * @return  登陆结果
     */
    public static boolean checkUserLogin(long uId){
        long id=uId;
        String key=String.valueOf(id);
        UserMag userMag=userLoginMagMap.get(key);
        if(userMag==null){
            logger.info("未登陆");
            return false;
        }
        Date loginTime=userMag.getLoginTime();
        Date nowTime=new Date();
        if(userMag.getLoginState()==LoginStateEnum.beOffLine.getState()){
            logger.info("已离线");
            return false;
        }
        //在线判断
        if(nowTime.getTime()-loginTime.getTime()<legal_time){
            userMag.setLoginState(LoginStateEnum.beOnLine.getState());
            userLoginMagMap.put(key,userMag);
            return true;
        }
        else {
            //修改登陆状态
            logger.info("登陆超时");
            userMag.setLoginState(LoginStateEnum.beOffLine.getState());
            return false;
        }
    }
    /**
     * @author 孙磊 on 2018/7/20
     * @apiNote 管理员登陆信息
     * @param  manager 管理员
     */
    public static boolean checkManagerLogin(Manager manager){
        long id=manager.getmId();
        String key=String.valueOf(id);
        ManagerMag managerMag=managerLoginMagMap.get(key);
        if(managerMag==null){
            logger.info("未登陆");
            return false;
        }
        Date loginTime=managerMag.getLoginTime();
        Date nowTime=new Date();
        //在线判断
        if(nowTime.getTime()-loginTime.getTime()<legal_time){
            //managerLoginMagMap.put(key,managerMag);
            return true;
        }
        else {
            //修改登陆状态
            logger.info("登陆超时");
            return false;
        }
    }
    /**
     * @author 孙磊 on 2018/7/20
     * @apiNote 管理员登陆检测
     * @param  mId 管理员id
     */
    public static boolean checkManagerLogin(long mId){
        String key=String.valueOf(mId);
        ManagerMag managerMag=managerLoginMagMap.get(key);
        if(managerMag==null){
            logger.info("未登陆");
            return false;
        }
        Date loginTime=managerMag.getLoginTime();
        Date nowTime=new Date();
        //在线判断
        if(nowTime.getTime()-loginTime.getTime()<legal_time){
            //managerLoginMagMap.put(key,managerMag);
            return true;
        }
        else {
            //修改登陆状态
            //logger.info("登陆超时");
            return false;
        }
    }
}
