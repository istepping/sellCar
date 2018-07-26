package com.car.service;

import com.car.biz.ManagerBiz;
import com.car.dto.ServiceResult;
import com.car.entity.Manager;
import com.car.enums.CarStateEnum;
import com.car.utils.ManagerMag;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

import static com.car.utils.LoginMag.managerLoginMagMap;
import static com.car.utils.LoginMag.userLoginMagMap;
import static com.car.utils.StaticMethod.logger;
/**
 * @author 孙磊 on 2018/7/18
 * @version 1.0
 * @apiNote
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:spring/applicationContext-*.xml"})
public class ManagerServiceTest {
    @Autowired
    ManagerService managerService;
    @Autowired
    ManagerBiz managerBiz;
    public void init(){
        Manager manager=managerBiz.getManagerByNameAndPassword("Selina","678901");
        managerLoginMagMap.put("1002",new ManagerMag(manager,new Date()));
    }
    /**
     * @author 孙磊 on 2018/7/18
     * @apiNote 测试函数
     */
    @Test
    public void test1(){
        init();
        ServiceResult serviceResult=managerService.changeCarPrice(1000,"Selina","678901","1.5万");
        ServiceResult serviceResult2=managerService.changeCarState(1000,"Selina","678901",CarStateEnum.offSell.getState());
        logger.info(serviceResult.toString());
    }
    /**
     * @author 孙磊 on 2018/7/18
     * @apiNote 测试函数
     */
    @Test
    public void test2(){
        init();
        managerService.orderReceiving(1000);
        managerService.rejectOrderReceiving(1001);
        managerService.createManager(managerLoginMagMap.get(String .valueOf(1002)).getManager(),new Manager(1,"sanshi","123456",2));
    }
}
