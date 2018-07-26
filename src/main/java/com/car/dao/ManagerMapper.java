package com.car.dao;

import com.car.entity.Manager;
import org.apache.ibatis.annotations.Param;

/**
 * @author 张兴邦 姜志刚 on 2018/7/13
 * @version 1.0
 * @apiNote manager表访问类
 */
public interface ManagerMapper {
    /**
     * @author 孙磊 on 2018/7/21
     * @apiNote 通过管理员id获取信息
     * @param  mId 管理员id
     * @return  Manger 返回数据
     */
    Manager queryById(long mId);
    /**
     * @author 张兴邦 姜志刚 on 2018/7/13
     * @apiNote  通过姓名与密码查询数据
     * @param  name 输入管理员姓名
     * @param  password 输入管理员密码
     * @return  Manager 返回数据
     */
    Manager queryByNameAndPassword(@Param("name") String name,@Param("password") String password);
    /**
     * @author 张兴邦 姜志刚 on 2018/7/13
     * @apiNote  增加一个管理员
     * @param  manager 要增加的管理员
     * @return int 返回执行结果
     */
    int insertManager(Manager manager);
    /**
     * @author 张兴邦 姜志刚 on 2018/7/13
     * @apiNote  注销一个管理员
     * @param  name 输入要注销的管理员姓名
     * @param  password 输入要注销的管理员的密码
     * @return int 返回执行结果
     */
    int deleteManager(@Param("name") String name,@Param("password") String password);
}
