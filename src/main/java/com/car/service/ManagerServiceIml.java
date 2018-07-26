package com.car.service;

import com.car.biz.CarBizIml;
import com.car.biz.ManagerBizIml;
import com.car.biz.OrderBizIml;
import com.car.biz.UserBizIml;
import com.car.dto.OrderInfo;
import com.car.dto.ServiceResult;
import com.car.entity.Car;
import com.car.entity.Manager;
import com.car.entity.Order;
import com.car.entity.User;
import com.car.enums.OrderStateEnum;
import com.car.enums.ManagerAuthorityEnum;
import com.car.enums.ResultStateEnum;
import com.car.exception.AuthorityException;
import com.car.utils.ManagerMag;

import static com.car.utils.LoginMag.managerLoginMagMap;
import static com.car.utils.StaticMethod.logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

import static com.car.utils.LoginMag.checkManagerLogin;
@Service
public class ManagerServiceIml implements ManagerService {
    @Autowired
    ManagerBizIml managerBiz;
    @Autowired
    CarBizIml carBizIml;
    @Autowired
    OrderBizIml orderBizIml;
    @Autowired
    UserBizIml userBizIml;

    @Override
    public ServiceResult getAllOrder(long mId,List<OrderInfo> orderList) {
        Manager manager=managerBiz.getManagerById(mId);
        if(checkManagerLogin(manager)){
            List<Order> orders = orderBizIml.getAllOrder();
            for (int i = 0; i < orders.size(); i++) {
                Order order = orders.get(i);
                long cId = order.getcId();
                long uId=order.getuId();
                Car car = carBizIml.getCarById(cId);
                User user=userBizIml.getUserById(uId);
                orderList.add(new OrderInfo(order.getoId(), user.getuName(), user.getuPhone(), user.getuAddress(), car.getcId(), car.getcBrand(), order.getoTime(), car.getcPrice(), order.getoState(), OrderStateEnum.orderCancel.getInfoByState(order.getoState())));
            }
            if (orderList != null) {
                return new ServiceResult(true, 1, "操作成功");
            } else {
                return new ServiceResult(false, -2, "数据不存在");
            }
        }
        else{
            return new ServiceResult(false,ResultStateEnum.logingError.getState(),ResultStateEnum.logingError.getInfo());
        }
    }

    @Override
    public ServiceResult addCar(long mId,Car car) {
        logger.info(car.toString());
        Manager manager=managerBiz.getManagerById(mId);
        if(checkManagerLogin(manager)){
            ManagerMag managerMag=managerLoginMagMap.get(String.valueOf(mId));
            if(managerMag.getManager().getmAuthority()>=ManagerAuthorityEnum.middleAuthority.getAuthority()){
                boolean result=carBizIml.addCar(car);
                if(result){
                    return new ServiceResult(true,ResultStateEnum.serviceSuccess.getState(),ResultStateEnum.serviceSuccess.getInfo());
                }
                else{
                    return new ServiceResult(false,ResultStateEnum.dataBaseError.getState(),ResultStateEnum.dataBaseError.getInfo());
                }
            }
            else{
                return new ServiceResult(false,ResultStateEnum.authorityError.getState(),ResultStateEnum.authorityError.getInfo());
            }
        }
        else{
            return new ServiceResult(false,ResultStateEnum.logingError.getState(),ResultStateEnum.logingError.getInfo());
        }
    }

    @Override
    public boolean managerLogin(String name, String password) {
        if (name.length() > 0 && name.length() < 20 && password.length() > 0 && password.length() < 20) {
            Manager manager = managerBiz.getManagerByNameAndPassword(name, password);
            if (manager != null) {
                //缓冲列表查询
                String managerKey = String.valueOf(manager.getmId());
                ManagerMag myManagerMag = managerLoginMagMap.get(managerKey);
                if (myManagerMag != null && checkManagerLogin(manager)) {
                    //在线
                    logger.info("你已经在线");
                    return true;
                }
                //登陆成功
                String key = String.valueOf(manager.getmId());
                ManagerMag managerMag = new ManagerMag(manager, new Date());
                managerLoginMagMap.put(key, managerMag);
                logger.info("重新登陆");
                return true;
            } else {
                //登录失败
                return false;
            }
        } else {
            return false;
        }
    }
    @Override
    public ServiceResult changeCarPrice(long cid, String name, String password, String price) {
        Manager manager = managerBiz.getManagerByNameAndPassword(name, password);
        Car car = carBizIml.getCarById(cid);
        if (checkManagerLogin(manager)) {
            if (manager.getmAuthority() == ManagerAuthorityEnum.topAuthority.getAuthority()) {
                carBizIml.changeCarPrice(cid, price);
                return new ServiceResult(true, 1, "修改成功");
            } else {
                return new ServiceResult(false, -2, "管理员权限不够");
            }
        } else {
            return new ServiceResult(false, -1, "已离线");
        }
    }
    @Override
    public ServiceResult changeCarState(long cid, String name, String password, int state) {
        Manager manager = managerBiz.getManagerByNameAndPassword(name, password);
        Car car = carBizIml.getCarById(cid);
        if (checkManagerLogin(manager)) {
            if (manager.getmAuthority() == ManagerAuthorityEnum.topAuthority.getAuthority()) {
                carBizIml.changeCarState(cid, state);
                return new ServiceResult(true, 1, "操作成功");
            } else {
                return new ServiceResult(false, -2, "管理员权限不够");
            }
        } else {
            return new ServiceResult(false, -1, "已离线");
        }
    }
    @Override
    public ServiceResult orderReceiving(long oId) {
        Order order = orderBizIml.getOrderInfo(oId);
        if (order == null) {
            return new ServiceResult(false, -1, "订单不存在");
        } else {
            boolean result = orderBizIml.changeOrderState(oId, OrderStateEnum.orderReceive.getState());
            if (result) {
                return new ServiceResult(true, 1, "操作成功");
            } else {
                return new ServiceResult(false, -2, "数据库操作失败");
            }
        }
    }
    @Override
    public ServiceResult rejectOrderReceiving(long oId) {
        Order order = orderBizIml.getOrderInfo(oId);
        if (order == null) {
            return new ServiceResult(false, -1, "订单不存在");
        } else {
            boolean result = orderBizIml.changeOrderState(oId, OrderStateEnum.orderCancel.getState());
            if (result == true) {
                return new ServiceResult(true, 1, "操作成功");
            } else {
                return new ServiceResult(false, -2, "取消订单失败");
            }
        }
    }
    @Override
    public ServiceResult createManager(Manager manager, Manager newManager) {
        try{
            if (manager.getmAuthority() != ManagerAuthorityEnum.topAuthority.getAuthority()){
                throw new AuthorityException("权限异常");
            }
        }catch (AuthorityException e){
            logger.info(e.getMessage());
            return new ServiceResult(false, -3, "权限不足");
        }
        if (newManager == null) {
            return new ServiceResult(false, -1, "管理员信息不存在");
        } else {
            boolean result = managerBiz.addManager(newManager);
            if (result) {
                return new ServiceResult(true, 1, "操作成功");
            } else {
                return new ServiceResult(false, -2, "增加管理员失败");
            }
        }
    }
}
