package com.car.service;

import com.car.dto.OrderInfo;
import com.car.dto.ServiceResult;
import com.car.entity.Car;
import com.car.entity.Manager;

import javax.sql.rowset.CachedRowSet;
import java.util.List;

/**
 * @author 孙磊 on 2018/7/15
 * @version 1.1 增加获取全部订单信息 by 孙磊 on 2018/7/22
 * @version 1.0
 * @apiNote
 */
public interface ManagerService {
    /**
     * @author 孙磊 on 2018/7/22
     * @apiNote 获取全部订单
     * @param  mId
     * @return  服务结果
     */
    ServiceResult getAllOrder(long mId,List<OrderInfo> orderList);
    /**
     * @author 孙磊 on 2018/7/20
     * @apiNote 管理员增加车辆
     * @param mId 操作管理员id
     * @param  car 新增加车
     * @return  服务结果
     */
    ServiceResult addCar(long mId,Car car);
    /**
     * @author 张兴邦 姜志刚 on 2018/7/15
     * @apiNote 管理员登录接口
     * @param  name 管理员名
     * @param password 密码
     * @return  boolean 返回登陆结果
     */
    boolean managerLogin(String name, String password);
    /**
     * @author 张兴邦 姜志刚 on 2018/7/17
     * @apiNote 管理员修改价格接口
     * @param cid 车id
     * @param  name 管理员姓名
     * @param  password 管理员姓名
     * @param price 新价格
     * @return  boolean 返回登陆结果
     */
    ServiceResult changeCarPrice(long cid,String name,String password,String price);
    /**
     * @author 张兴邦 姜志刚 on 2018/7/17
     * @apiNote 管理员修改车辆状态接口
     * @param cid 车id
     * @param  name 管理员姓名
     * @param  password 管理员姓名
     * @param state 新状态
     * @return  boolean 返回登陆结果
     */
    ServiceResult changeCarState(long cid, String name, String password, int state);
    /**
     * @author 张兴邦 姜志刚 on 2018/7/15
     * @apiNote 管理员接单
     * @param oId 订单编号
     * @return  boolean 返回登陆结果
     */
    ServiceResult orderReceiving(long oId);
    /**
     * @author 张兴邦 姜志刚 on 2018/7/15
     * @apiNote 管理员拒绝接单
     * @param oId 订单编号
     * @return  boolean 返回登陆结果
     */
    ServiceResult rejectOrderReceiving(long oId);
    /**
     * @author 张兴邦 姜志刚 on 2018/7/15
     * @apiNote 管理员增加管理员
     * @param manager 操作对象
     * @param newManager 增加的还离远
     * @return  boolean 返回登陆结果
     */
    ServiceResult createManager(Manager manager,Manager newManager);

}
