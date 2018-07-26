package com.car.biz;

import com.car.entity.User;
import org.springframework.stereotype.Component;

/**
 * @author 孙磊 on 2018/7/15
 * @version 1.0
 * @apiNote
 */
public interface UserBiz {
    /**
     * @author 孙磊 on 2018/7/21
     * @apiNote 获取用户通过id
     * @param  uId 用户id
     * @return  用户
     */
    User getUserById(long uId);
    /**
     * @author 孙磊 on 2018/7/15
     * @apiNote 获取用户账户
     * @param  name 用户名
     * @param password 密码
     * @return  用户账号
     */
    User getUserByNameAndPassword(String name,String password);
    /**
     * @author 孙磊 on 2018/7/19
     * @apiNote 获取用户信息
     * @param  name 用户名
     * @return  用户信息
     */
    User getUserByName(String name);
    /**
     * @author 孙磊 on 2018/7/19
     * @apiNote 注册用户
     * @param  user 用户名
     * @return  用户信息
     */
    boolean addUser(User user);
    /**
     * @author 孙磊 on 2018/7/15
     * @apiNote 改变用户状态
     * @param  name String 用户名
     * @param password String 用户密码
     * @param state 新状态
     * @return  返回执行结果
     */
    boolean changeUserState(String name,String password,int state);
    /**
     * @author 孙磊 on 2018/7/16
     * @apiNote 更改用户手机号
     * @param  name String 用户名
     * @param password String 用户密码
     * @param phone 新手机号
     * @return  返回执行结果
     */
    boolean changeUserPhone(String name,String password,String phone);
    /**
     * @author 张兴邦 姜志刚 on 2018/7/16
     * @apiNote 更改用户地址
     * @param  name String 用户名
     * @param password String 用户密码
     * @param address 新手机号
     * @return  返回执行结果
     */
    boolean changeUserAddress(String name,String password,String address);
    /**
     * @author 张兴邦 姜志刚 on 2018/7/16
     * @apiNote  通过用户姓名与密码修改密码
     * @param  uId 传入一个用户id
     * @param password 传入新密码
     * @return int 返回执行结果
     */
    boolean changeUserPassword(long uId,String password);
}
