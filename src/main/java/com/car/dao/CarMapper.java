package com.car.dao;

import com.car.entity.Car;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 孙磊 on 2018/7/13
 * @version 1.0
 * @apiNote car表访问类
 */
public interface CarMapper {
    /**
     * @author 孙磊 on 2018/7/13
     * @apiNote  通过车id查询数据
     * @param  id 输入车id号
     * @return  Car 返回数据
     */
    Car queryById(long id);
    /**
     * @author 孙磊 on 2018/7/13
     * @apiNote 查询所有车信息
     * @return 返回所有车类集合
     */
    List<Car> queryAll();
    /**
     * @author 孙磊 on 2018/7/13
     * @apiNote 增加一辆车
     * @param  car 要增加的车信息
     * @return int 受影响的行
     */
    int insertCar(Car car);
    /**
     * @author 孙磊 on 2018/7/13
     * @apiNote 更新车价格功能
     * @param  id 传入的车id
     * @param  price 新价格
     * @return  执行结果
     */
    int updateCarPrice(@Param("id") long id,@Param("price") String price);
    /**
     * @author 孙磊 on 2018/7/13
     * @apiNote 更新车的销售状态信息
     * @param  id 车id
     * @param state 新状态
     * @return int 返回执行结果
     */
    int updateCarState(@Param("id") long id,@Param("state") int state);
    /**
     * @author 孙磊 on 2018/7/14
     * @apiNote 删除车信息
     * @param  id 车id
     * @return  执行结果
     */
    int deleteCar(@Param("id") long id);
    /**
     * @author 姜志刚&张兴邦 on 2018/7/13
     * @apiNote 更改汽车库存
     * @param  id 汽车编号
     * @param num 新库存
     * @return int 受影响的行
     */
    int updateCarNum(@Param("id") long id,@Param("num") int num);
    /**
     * @author 孙磊 on 2018/7/18
     * @apiNote 通过车类型查看车数据
     * @param  cCatalog 车类型
     * @return  车数据
     */
    List<Car> queryCarByCatalog(@Param("cCatalog") String cCatalog);
}
