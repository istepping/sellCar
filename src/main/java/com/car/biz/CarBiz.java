package com.car.biz;

import com.car.entity.Car;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 姜志刚&张兴邦 on 2018/7/15
 * @version 1.0
 * @apiNote
 */
public interface CarBiz {
    /**
     * @author 姜志刚&张兴邦on 2018/7/15
     * @apiNote 获取汽车信息
     * @param  id 汽车Id
     * @return  汽车对象
     */
    Car getCarById(long id);
    /**
     * @author 姜志刚&张兴邦 on 2018/7/15
     * @apiNote 获取所有汽车信息
     * @return  所有汽车信息
     */
    List<Car> getAllCar();
    /**
     * @author 姜志刚&张兴邦 on 2018/7/13
     * @apiNote 增加一辆车
     * @param  car 要增加的车信息
     * @return 返回执行结果
     */
    boolean addCar(Car car);
    /**
     * @author 姜志刚&张兴邦on 2018/7/13
     * @apiNote 更新车价格功能
     * @param  id 传入的车id
     * @param  price 新价格
     * @return  执行结果
     */
    boolean changeCarPrice(long id,String price);
    /**
     * @author 姜志刚&张兴邦 on 2018/7/13
     * @apiNote 更新车的销售状态信息
     * @param  id 车id
     * @param state 新状态
     * @return int 返回执行结果
     */
    boolean changeCarState(long id,int state);
    /**
     * @author 姜志刚&张兴邦 on 2018/7/13
     * @apiNote 更改汽车库存
     * @param  id 汽车编号
     * @return 返回执行结果
     */
    boolean changeCarNum(long id,int num);
    /**
     * @author 孙磊 on 2018/7/18
     * @apiNote 通过车类型查看车数据
     * @param  cCatalog 车类型
     * @return  车数据
     */
    List<Car> getCarByCatalog(String cCatalog);
}
