package com.car.service;

import com.car.dto.OrderInfo;
import com.car.dto.ServiceResult;
import com.car.entity.Car;
import com.car.entity.Order;
import com.car.entity.User;

import java.util.List;

/**
 * @author 孙磊 on 2018/7/15
 * @version 1.0
 * @apiNote 用户服务接口
 */
public interface UserService {
    /**
     * @author 孙磊 on 2018/7/15
     * @apiNote 用户登录接口
     * @param  name 用户名
     * @param password 密码
     * @return  boolean 返回登陆结果
     */
    boolean userLogin(String name,String password);
    /**
     * @author 孙磊 on 2018/7/22
     * @apiNote 退出登陆.
     * @param  uId 用户id
     * @return  服务结果
     */
    ServiceResult userLoginOut(long uId);
    /**
     * @author 孙磊 on 2018/7/19
     * @apiNote 用户注册功能
     * @param
     * @return
     */
    ServiceResult userRegister(String name,String password,String phone,String address);
    /**
     * @author 孙磊 on 2018/7/16
     * @apiNote 更改用户手机号
     * @param  uId 用户id
     * @param  phone 新手机号
     * @return  服务结果
     */
    ServiceResult changeUserPhone(long uId,String phone);
    /**
     * @author 孙磊 on 2018/7/20
     * @apiNote 取消订单
     * @param  uId 用户id
     * @param oId 订单id
     * @return  服务结果
     */
    ServiceResult cancelOrder(long uId,long oId);
    /**
     * @author 张兴邦 姜志刚 on 2018/7/16
     * @apiNote 更改用户地址
     * @param  uId 用户id
     * @param  address 新地址
     * @return  服务结果
     */
    ServiceResult changeUserAddress(long uId,String address);
    /**
     * @author 孙磊 on 2018/7/21
     * @apiNote 增加订单
     * @param  uId 用户id
     * @param cId 车id
     * @return
     */
    ServiceResult addOrder(long uId,long cId);
    /**
     * @author 张兴邦 姜志刚 on 2018/7/16
     * @apiNote 查看订单
     * @param  uid 用户id
     * @param orderList 查询的数据
     * @return  服务结果
     */
    ServiceResult lookOrder(long uid, List<OrderInfo> orderList);
    /**
     * @author 张兴邦 姜志刚 on 2018/7/16
     * @apiNote 付款
     * @param  uid 用户id
     * @param oid 订单id
     * @return  服务结果
     */
    ServiceResult payForOrder(long oid,long uid);
    /**
     * @author 张兴邦 姜志刚 on 2018/7/16
     * @apiNote 付款
     * @param  carList 车数据
     * @return  服务结果
     */
    ServiceResult  lookAllCar(List<Car> carList);
    /**
     * @author 张兴邦 姜志刚 on 2018/7/16
     * @apiNote 付款
     * @param  carList 收藏的车数据
     * @return  服务结果
     */
    ServiceResult  lookCollection(long uid,List<Car> carList);
    /**
     * @author 张兴邦 姜志刚 on 2018/7/16
     * @apiNote  通过用户姓名与密码修改密码
     * @param  uId 用户
     * @param password 原密码
     * @param newPassword 新密码
     * @return 服务结果
     */
    ServiceResult changeUserPassword(long uId,String password,String newPassword);
    //收藏相关接口
    /**
     * @author 孙磊 on 2018/7/20
     * @apiNote 增加收藏
     * @param  uId 用户id
     * @param cId 车id
     * @return
     */
    ServiceResult addCollection(long uId,long cId);
    /**
     * @author 孙磊 on 2018/7/20
     * @apiNote 取消收藏
     * @param  uId 用户id
     * @param cId 车id
     * @return
     */
    ServiceResult cancelCollection(long uId,long cId);
}
