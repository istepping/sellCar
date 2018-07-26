package com.car.biz;
import com.car.dao.UserMapper;
import com.car.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.car.utils.StaticMethod.logger;
/**
 * @author 孙磊 on 2018/7/15
 * @version 1.0
 * @apiNote
 */
@Component
public class UserBizIml implements UserBiz{
    @Autowired
    UserMapper userMapper;

    @Override
    public User getUserById(long uId) {
        return userMapper.queryById(uId);
    }

    @Override
    public User getUserByNameAndPassword(String name, String password) {
        return userMapper.queryByNameAndPassword(name,password);
    }
    @Override
    public User getUserByName(String name) {
        return userMapper.queryUserByName(name);
    }
    @Override
    public boolean addUser(User user) {
        int result=userMapper.insertUser(user);
        if(result>0){
            return true;
        }
        else {
            return false;
        }
    }
    @Override
    public boolean changeUserState(String name, String password,int state) {
        int result=userMapper.updateUserState(name,password,state);
        logger.info(this.getClass()+"result"+result);
        if(result>0){
            return true;
        }
        else {
            return false;
        }
    }
    @Override
    public boolean changeUserPhone(String name, String password, String phone) {
        int result=userMapper.updateUserPhone(name,password,phone);
        logger.info(this.getClass()+"result"+result);
        if(result>0){
            return true;
        }
        else {
            return false;
        }
    }
    @Override
    public boolean changeUserAddress(String name, String password, String address) {
        int result=userMapper.updateUserAddress(name,password,address);
        logger.info(this.getClass()+"result"+result);
        if(result>0){
            return true;
        }
        else {
            return false;
        }
    }
    @Override
    public boolean changeUserPassword(long uId,String password){
        int result=userMapper.updateUserPassword(uId,password);
        logger.info(this.getClass()+"result"+result);
        if(result>0){
            return true;
        }
        else {
            return false;
        }
    }
}
