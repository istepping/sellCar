package com.car.service;

import com.car.biz.CollectBizIml;
import com.car.biz.OrderBiz;
import com.car.biz.UserBizIml;
import com.car.dto.OrderInfo;
import com.car.dto.ServiceResult;
import com.car.entity.Car;
import com.car.entity.Order;
import com.car.entity.User;
import com.car.enums.CarSortEnum;
import com.car.enums.LoginStateEnum;
import com.car.utils.UserMag;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.car.utils.LoginMag.userLoginMagMap;
import static com.car.utils.StaticMethod.logger;

/**
 * @author 孙磊 on 2018/7/16
 * @version 1.0
 * @apiNote service层测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:spring/applicationContext-*.xml"})
public class UserServiceTest {
    @Autowired
    private UserServiceIml userService;
    @Autowired
    private UserBizIml userBiz;
    @Autowired
    private CollectBizIml collectBiz;
    @Autowired
    private OrderBiz order;
    public void init(){
        User user=userBiz.getUserByNameAndPassword("Tom","123456");
        userLoginMagMap.put("1000",new UserMag(user,new Date(),LoginStateEnum.beOnLine.getState()));
    }
    @Test
    public void test1(){
        init();
        logger.info(userService.changeUserPhone(1000,"12345678901").getInfo());
        logger.info(userService.changeUserAddress(1000,"软件学院").getInfo());
    }
    @Test
    public void test2(){
        init();
        List<OrderInfo> orderList=new ArrayList<>();
        ServiceResult result= userService.lookOrder(1000,orderList);
        logger.info(result.getInfo());
        for(int i=0;i<orderList.size();i++){
            OrderInfo order=orderList.get(i);
            logger.info(order.toString());
        }
        //order.addOrder(1000,1000);
        ServiceResult result1=userService.payForOrder(1000,1000);
        logger.info(result1.getInfo());
    }
    @Test
    public void test3(){
        init();
        List<Car> carList=new ArrayList<>();
        ServiceResult result=userService.lookAllCar(carList);
        logger.info(result.getInfo());
        for(int i=0;i<carList.size();i++){
            Car car=carList.get(i);
            logger.info(car.toString());
        }
        collectBiz.addCollect(1000,1002);
        List<Car> carList1=new ArrayList<>();
        ServiceResult result2=userService.lookCollection(1000,carList1);
        logger.info(result2.getInfo());
        for(int i=0;i<carList1.size();i++){
            Car car1=carList1.get(i);
            logger.info(car1.toString());
        }
    }
    @Test
    public void test4(){
        logger.info(CarSortEnum.NEV.getInfo());
    }
}
