package com.car.biz;

import com.car.dao.CarMapper;
import com.car.dao.cache.Redis;
import com.car.entity.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import static com.car.utils.StaticMethod.logger;
/**
 * @author 姜志刚&张兴邦 on 2018/7/15
 * @version 1.0
 * @apiNote
 */
@Component
public class CarBizIml implements CarBiz{
    @Autowired
    CarMapper carMapper;
    @Autowired
    private Redis redis;
    @Override
    public Car getCarById(long id){
        //查询缓存数据库
//        Car car=redis.get(id);
//        if(car==null){
//            car=carMapper.queryById(id);
//            //放入redis
//            redis.set(car);
//        }
//        return car;
        return carMapper.queryById(id);
    }
    @Override
    public List<Car> getAllCar(){
        return carMapper.queryAll();
    }
    @Override
    public boolean addCar(Car car){
        int result = carMapper.insertCar(car);
        //logger.info(this.getClass()+"result"+result);
        if(result>0){
            return true;
        }
        else {
            return false;
        }
    }
    @Override
    public boolean changeCarPrice(long id,String price){
        int result = carMapper.updateCarPrice(id,price);
        //logger.info(this.getClass()+"result"+result);
        if(result>0){
            return true;
        }
        else {
            return false;
        }
    }
    @Override
    public boolean changeCarState(long id,int state){
        int result = carMapper.updateCarState(id,state);
        //logger.info(this.getClass()+"result"+result);
        if(result>0){
            return true;
        }
        else {
            return false;
        }
    }
    @Override
    public boolean changeCarNum(long id,int num){
        int result = carMapper.updateCarNum(id,num);
        //logger.info(this.getClass()+"result"+result);
        if(result>0){
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public List<Car> getCarByCatalog(String cCatalog) {
        return carMapper.queryCarByCatalog(cCatalog);
    }
}
