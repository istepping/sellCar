package com.car.dao;

import com.car.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author 张兴邦 & 姜志刚 on 2018/7/13
 * @version 1.0
 * @apiNote
 */
public interface UserMapper {
    /**
     * @author 孙磊 on 2018/7/21
     * @apiNote 通过uId查询用户
     * @param  uId 用户id
     * @return  User 返回数据
     */
    User queryById(long uId);
    /**
     * @author 孙磊 on 2018/7/19
     * @apiNote 通过用户名返回信息
     * @param  uName 用户名
     * @return  int 执行结果
     */
    User queryUserByName(String uName);
    /**
     * @author 张兴邦 姜志刚 on 2018/7/13
     * @apiNote  通过用户姓名与密码查询数据
     * @param  name 输入用户姓名
     * @param  password 输入用户密码
     * @return  User 返回数据
     */
    User queryByNameAndPassword(@Param("name") String name,@Param("password") String password);
    /**
     * @author 张兴邦 姜志刚 on 2018/7/13
     * @apiNote  增加一个用户
     * @param  user 要增加的用户
     * @return int 返回执行结果
     */
    int insertUser(User user);
    /**
     * @author 张兴邦 姜志刚 on 2018/7/13
     * @apiNote  注销一个用户
     * @param  name 输入要注销的用户姓名
     * @param  password 输入要注销的用户的密码
     * @return int 返回执行结果
     */
    int deleteUser(@Param("name") String name,@Param("password") String password);
    /**
     * @author 张兴邦 姜志刚 on 2018/7/13
     * @apiNote  通过用户姓名与密码修改电话
     * @param  name 输入用户姓名
     * @param password 输入用户密码
     * @param phone 输入新电话
     * @return int 返回执行结果
     */
    int updateUserPhone(@Param("name") String name,@Param("password") String password,@Param("phone") String phone);
    /**
     * @author 张兴邦 姜志刚 on 2018/7/13
     * @apiNote  通过用户姓名与密码修改地址
     * @param  name 输入用户姓名
     * @param password 输入用户密码
     * @param address 输入新地址
     * @return int 返回执行结果
     */
    int updateUserAddress(@Param("name") String name,@Param("password") String password,@Param("address")String address);
    /**
     * @author 孙磊 on 2018/7/15
     * @apiNote 通过用户名密码修改登陆状态
     * @param  name String 用户名
     * @param  password String 密码
     * @param state int 用户账户状态
     * @return  int 执行结果
     */
    int updateUserState(@Param("name") String  name,@Param("password") String password,@Param("state") int state);
    /**
     * @author 张兴邦 姜志刚 on 2018/7/16
     * @apiNote  通过用户姓名与密码修改密码
     * @param  uId 传入一个用户id
     * @param password 传入新密码
     * @return int 返回执行结果
     */
    int updateUserPassword(@Param("uId") long uId,@Param("password") String password);
}
