package com.car.service;

import com.car.biz.*;
import com.car.dto.OrderInfo;
import com.car.dto.ServiceResult;
import com.car.entity.Car;
import com.car.entity.Collect;
import com.car.entity.Order;
import com.car.entity.User;
import com.car.enums.CarStateEnum;
import com.car.enums.LoginStateEnum;
import com.car.enums.OrderStateEnum;
import com.car.enums.ResultStateEnum;
import com.car.utils.UserMag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

import static com.car.utils.LoginMag.checkUserLogin;
import static com.car.utils.LoginMag.userLoginMagMap;

/**
 * @author 孙磊 on 2018/7/15
 * @version 1.0
 * @apiNote 用户服务接口实现类
 */
@Service
public class UserServiceIml implements UserService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private UserBizIml userBiz;
    @Autowired
    private ManagerBizIml managerBizIml;
    @Autowired
    private OrderBizIml orderBizIml;
    @Autowired
    private CarBizIml carBizIml;
    @Autowired
    private CollectBizIml collectBizIml;

    @Override
    public boolean userLogin(String name, String password) {
        if (name.length() > 0 && name.length() < 20 && password.length() > 0 && password.length() < 20) {
            User user = userBiz.getUserByNameAndPassword(name, password);
            if (user != null) {
                //缓冲列表查询
                String userKey = String.valueOf(user.getuId());
                UserMag myUserMag = userLoginMagMap.get(userKey);
                if (myUserMag != null && checkUserLogin(user.getuId())) {
                    //在线
                    logger.info("你已经在线");
                    return true;
                }
                //登陆成功
                String key = String.valueOf(user.getuId());
                UserMag userMag = new UserMag(user, new Date(), LoginStateEnum.beOnLine.getState());
                userLoginMagMap.put(key, userMag);
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
    public ServiceResult userLoginOut(long uId) {
        if (checkUserLogin(uId)) {
            userLoginMagMap.remove(String.valueOf(uId));
        }
        return new ServiceResult(true, ResultStateEnum.serviceSuccess.getState(), ResultStateEnum.serviceSuccess.getInfo());
    }

    @Override
    public ServiceResult userRegister(String name, String password, String phone, String address) {
        User user = userBiz.getUserByName(name);
        if (user != null) {
            return new ServiceResult(false, -1, "用户名已经存在");
        }
        if (name.length() > 0 && name.length() <= 20 && password.length() > 0 && password.length() <= 20) {
            boolean result = userBiz.addUser(new User(1000, name, password, phone, address, 1));
            if (result == false) {
                return new ServiceResult(false, -3, "数据库操作异常");
            } else {
                return new ServiceResult(true, 1, "操作成功");
            }
        } else {
            return new ServiceResult(false, -1, "不符合要求的用户名，密码");
        }
    }

    @Override
    public ServiceResult changeUserPhone(long uId, String phone) {
        //uId查询数据, 判断登陆情况,执行修改操作,返回服务结果
        if (uId < 1000) {
            return new ServiceResult(false, -1, "不存在该用户");
        }
        if(phone.length()!=11){
            return new ServiceResult(false,ResultStateEnum.inputError.getState(),ResultStateEnum.inputError.getInfo());
        }
        String userKey = String.valueOf(uId);
        UserMag userMag = userLoginMagMap.get(userKey);
        if (userMag == null) {
            return new ServiceResult(false, -2, "已离线");
        }
        boolean result = userBiz.changeUserPhone(userMag.getUser().getuName(), userMag.getUser().getuPassword(), phone);
        if (result == false) {
            return new ServiceResult(false, -3, "数据库操作异常");
        } else {
            return new ServiceResult(true, 1, "操作成功");
        }
    }

    @Override
    public ServiceResult changeUserAddress(long uId, String address) {
        //uId查询数据, 判断登陆情况,执行修改操作,返回服务结果
        if (uId < 1000) {
            return new ServiceResult(false, -1, "不存在该用户");
        }
        String userKey = String.valueOf(uId);
        UserMag userMag = userLoginMagMap.get(userKey);
        if (userMag == null) {
            return new ServiceResult(false, -2, "已离线");
        }
        boolean result = userBiz.changeUserAddress(userMag.getUser().getuName(), userMag.getUser().getuPassword(), address);
        if (result == false) {
            return new ServiceResult(false, -3, "数据库操作异常");
        } else {
            return new ServiceResult(true, 1, "操作成功");
        }
    }

    @Override
    public ServiceResult addOrder(long uId, long cId) {
        if(checkUserLogin(uId)){
            Car car=carBizIml.getCarById(cId);
            if(car.getcState()==CarStateEnum.beSell.getState()){
                boolean result=orderBizIml.addOrder(uId,cId);
                if(result){
                    return new ServiceResult(true,ResultStateEnum.serviceSuccess.getState(),ResultStateEnum.serviceSuccess.getInfo());
                }else{
                    return new ServiceResult(false,ResultStateEnum.dataBaseError.getState(),ResultStateEnum.dataBaseError.getInfo());
                }
            }
            else{
                return new ServiceResult(false,ResultStateEnum.inputError.getState(),ResultStateEnum.inputError.getInfo());
            }
        }else{
            return new ServiceResult(false,ResultStateEnum.logingError.getState(),ResultStateEnum.logingError.getInfo());
        }
    }

    @Override
    public ServiceResult lookOrder(long uid, List<OrderInfo> orderList) {
        if (checkUserLogin(uid)) {
            User user = userLoginMagMap.get(String.valueOf(uid)).getUser();
            List<Order> orders = orderBizIml.getOrder(uid);
            OrderInfo orderInfo;
            for (int i = 0; i < orders.size(); i++) {
                Order order = orders.get(i);
                long cId = order.getcId();
                Car car = carBizIml.getCarById(cId);
                orderList.add(new OrderInfo(order.getoId(), user.getuName(), user.getuPhone(), user.getuAddress(), car.getcId(), car.getcBrand(), order.getoTime(), car.getcPrice(), order.getoState(), OrderStateEnum.orderCancel.getInfoByState(order.getoState())));
            }
            if (orderList != null) {
                return new ServiceResult(true, 1, "操作成功");
            } else {
                return new ServiceResult(false, -2, "数据不存在");
            }
        } else {
            return new ServiceResult(false, -1, "不存在该用户");
        }
    }

    @Override
    public ServiceResult payForOrder(long oid, long uid) {
        if (checkUserLogin(uid)) {
            Order order = orderBizIml.getOrderInfo(oid);
            if (order.getoState() == OrderStateEnum.orderPay.getState()) {
                return new ServiceResult(false, -2, "已付款成功，不能再次付款");
            }
            if (order.getoState() == OrderStateEnum.orderCancel.getState()) {
                return new ServiceResult(false, -3, "已取消订单，不能付款");
            }
            if (order.getoState() == OrderStateEnum.orderSuccess.getState()) {
                boolean result = orderBizIml.changeOrderState(oid, OrderStateEnum.orderPay.getState());
                if (result == false) {
                    return new ServiceResult(false, -4, "数据库操作异常");
                } else {
                    return new ServiceResult(true, 1, "操作成功");
                }
            } else {
                return new ServiceResult(true, -5, "操作失败");
            }
        } else {
            return new ServiceResult(false, -1, "已离线");
        }
    }

    @Override
    public ServiceResult lookAllCar(List<Car> carList) {
        List<Car> cars = carBizIml.getAllCar();
        for (int i = 0; i < cars.size(); i++) {
            carList.add(cars.get(i));
        }
        if (carList != null) {
            return new ServiceResult(true, 1, "操作成功");
        } else {
            return new ServiceResult(false, -1, "数据不存在");
        }
    }

    @Override
    public ServiceResult lookCollection(long uId, List<Car> carList) {
        if (checkUserLogin(uId)) {
            List<Collect> collects = collectBizIml.getAllCollect(uId);
            for (int i = 0; i < collects.size(); i++) {
                carList.add(carBizIml.getCarById(collects.get(i).getcId()));
            }
            if (carList != null) {
                return new ServiceResult(true, 1, "操作成功");
            } else {
                return new ServiceResult(false, -2, "数据不存在");
            }
        } else {
            return new ServiceResult(false, -1, "已离线");
        }
    }

    @Override
    public ServiceResult cancelOrder(long uId, long oId) {
        if (checkUserLogin(uId)) {
            boolean result = orderBizIml.changeOrderState(oId, OrderStateEnum.orderCancel.getState());
            if (result) {
                return new ServiceResult(true, ResultStateEnum.serviceSuccess.getState(), ResultStateEnum.serviceSuccess.getInfo());
            } else {
                return new ServiceResult(false, ResultStateEnum.dataBaseError.getState(), ResultStateEnum.dataBaseError.getInfo());
            }
        } else {
            return new ServiceResult(false, ResultStateEnum.logingError.getState(), ResultStateEnum.logingError.getInfo());
        }
    }

    @Override
    public ServiceResult changeUserPassword(long uId, String password, String newPassword) {
        if (uId <1000) {
            return new ServiceResult(false, -1, "用户信息不存在");
        } else {
            if (checkUserLogin(uId)) {
                User user=userLoginMagMap.get(String.valueOf(uId)).getUser();
                if (userBiz.getUserByNameAndPassword(user.getuName(), password) == null) {
                    return new ServiceResult(false, -4, "密码不正确");
                }
                boolean result = userBiz.changeUserPassword(user.getuId(), newPassword);
                if (result) {
                    return new ServiceResult(true, 1, "操作成功");
                } else {
                    return new ServiceResult(false, -3, "数据操作失败");
                }
            } else {
                return new ServiceResult(false, -2, "用户未登录");
            }
        }
    }
    @Override
    public ServiceResult addCollection(long uId, long cId) {
        if (checkUserLogin(uId)) {
            if (carBizIml.getCarById(cId) != null) {
                //存在该车
                boolean result = collectBizIml.addCollect(uId, cId);
                if (result) {
                    return new ServiceResult(true, ResultStateEnum.serviceSuccess.getState(), ResultStateEnum.serviceSuccess.getInfo());
                } else {
                    return new ServiceResult(false, ResultStateEnum.dataBaseError.getState(), ResultStateEnum.dataBaseError.getInfo());
                }
            } else {
                return new ServiceResult(false, ResultStateEnum.inputError.getState(), ResultStateEnum.inputError.getInfo());
            }
        } else {
            return new ServiceResult(false, ResultStateEnum.logingError.getState(), ResultStateEnum.logingError.getInfo());
        }
    }
    @Override
    public ServiceResult cancelCollection(long uId, long cId) {
        if (checkUserLogin(uId)) {
            boolean result = collectBizIml.removeCollect(uId, cId);
            if (result) {
                return new ServiceResult(true, ResultStateEnum.serviceSuccess.getState(), ResultStateEnum.serviceSuccess.getInfo());
            } else {
                return new ServiceResult(false, ResultStateEnum.dataBaseError.getState(), ResultStateEnum.dataBaseError.getInfo());
            }
        } else {
            return new ServiceResult(false, ResultStateEnum.logingError.getState(), ResultStateEnum.logingError.getInfo());
        }
    }
}
