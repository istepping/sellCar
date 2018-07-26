package com.car.dao;

import com.car.entity.*;
import com.car.enums.CarSortEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author 孙磊 on 2018/7/13
 * @version 1.0
 * @apiNote  sql语句的测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/applicationContext-dao.xml"})
public class SQLtest {
    private Logger logger=LoggerFactory.getLogger(this.getClass());
    @Autowired
    CarMapper carMapper;
    @Autowired
    CollectMapper collectMapper;
    @Autowired
    ManagerMapper managerMapper;
    @Autowired
    OrderMapper orderMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    ImageMapper imageMapper;
    /**
     * @author 孙磊 on 2018/7/13
     * @version 1.0
     * @apiNote  sql语句的测试
     */
    @Test
    public void queryByCarId(){
        long id=1001;
        logger.info(carMapper.queryById(id).toString());
        Car car=new Suv(1000,"a","2","3",4,"4",1,"SUV","1");
        carMapper.insertCar(car);
        carMapper.deleteCar(1010);
        carMapper.deleteCar(1011);
        carMapper.deleteCar(1012);
        carMapper.deleteCar(1013);
        carMapper.deleteCar(1014);
        carMapper.updateCarState(1000,1);
        carMapper.updateCarPrice(1000,"14万");
    }
    @Test
    public void collectMapperTest(){
        collectMapper.insertCollect(1000,1000);
        logger.info(collectMapper.queryByuId(1000)+"");
        collectMapper.deleteCollect(1000,1000);
    }
    /**
     * @author 姜志刚 张兴邦 on 2018/7/14
     * @version 1.0
     * @apiNote  sql语句的测试
     */
    @Test
    public void managerMapperTest(){
        Manager manager = new Manager(1200, "john", "67890", 1);
        logger.info("" + managerMapper.insertManager(manager));
        logger.info(managerMapper.queryByNameAndPassword("Tim", "456789").toString());
        logger.info("" + managerMapper.deleteManager("john", "67890"));
        managerMapper.queryByNameAndPassword("john", "67890");
    }
    /**
     * @author 姜志刚 张兴邦 on 2018/7/14
     * @version 1.0
     * @apiNote  sql语句的测试
     */
    @Test
    public void orderMapperTest(){
        orderMapper.insertOrder(1000, 1005);
        orderMapper.insertOrder(1000, 1006);
        logger.info(orderMapper.queryById(1005).toString());
        List<Order> order = orderMapper.queryAll();
        for (int i = 0; i < order.size(); i++) {
            logger.info(order.get(i).toString());
            System.out.print("\n");
        }
        orderMapper.deleteOrder(1000);
        orderMapper.updateOrderState(1001, 2);
        List<Order> order2 = orderMapper.queryAll();
        for (int i = 0; i < order2.size(); i++) {
            logger.info(order2.get(i).toString());
            System.out.print("\n");
        }
    }
    /**
     * @author 姜志刚 张兴邦 on 2018/7/14
     * @version 1.0
     * @apiNote  sql语句的测试
     */
    @Test
    public void userMapperTest(){
        logger.info(userMapper.queryByNameAndPassword("Tom", "123456").toString());
        User user = new User(1100, "Mile", "123456789", "18742585840", "大连市",1);
        logger.info("" + userMapper.insertUser(user));
        userMapper.updateUserPhone("Tom", "123456", "18742585840");
        userMapper.updateUserAddress("Tom", "123456", "上海市");
        userMapper.deleteUser("Tom", "123456");
    }
    /**
     * @author 孙磊 on 2018/7/18
     * @apiNote sql测试代码
     */
    @Test
    public void otherTest(){
        orderMapper.insertOrder(1000, 1005);
        List<Order> orderList=orderMapper.queryByUserId(1000);
        logger.info(orderList.get(0).toString());
    }
    @Test
    public void test1(){
        String s="sportCar";
        List<Car> cars=carMapper.queryCarByCatalog(s);
        for(int i=0;i<cars.size();i++){
            Car car=cars.get(i);
            logger.info(car.toString());
        }
        Image image= imageMapper.queryById(1000);
        logger.info(image.toString());
    }
}
