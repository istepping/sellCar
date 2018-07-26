package com.car.biz;

import com.car.dao.CarMapper;
import com.car.dao.ManagerMapper;
import com.car.entity.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.car.utils.StaticMethod.logger;

/**
 * @author 张兴邦 姜志刚 on 2018/7/15
 * @version 1.0
 * @apiNote ManagerBiz实现类
 */
@Component
public class ManagerBizIml implements ManagerBiz{
    @Autowired
    ManagerMapper managerMapper;
    @Autowired
    CarMapper carMapper;

    @Override
    public Manager getManagerById(long mId) {
        return managerMapper.queryById(mId);
    }

    @Override
    public Manager getManagerByNameAndPassword(String name, String password) {
        return managerMapper.queryByNameAndPassword(name,password);
    }
    @Override
    public boolean changeCarPrice(long cid,String price){
        int result=carMapper.updateCarPrice(cid,price);
        if(result>0){
            return true;
        }
        else {
            return false;
        }
    }
    @Override
    public boolean changeCarState(long cid,int state){
        int result=carMapper.updateCarState(cid,state);
        if(result>0){
            return true;
        }
        else {
            return false;
        }
    }
    @Override
    public boolean addManager(Manager manager){
        int result = managerMapper.insertManager(manager);
        logger.info(this.getClass()+"result"+result);
        if(result>0){
            return true;
        }
        else {
            return false;
        }
    }

}
