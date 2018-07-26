package com.car.biz;

import com.car.entity.Manager;
import org.springframework.stereotype.Component;

/**
 * @author 张兴邦 姜志刚 on 2018/7/15
 * @version 1.1 增加通过id查询 by 孙磊 on 2018/7/21
 * @version 1.0
 * @apiNote ManagerBiz接口
 */

public interface ManagerBiz {
    /**
     * @author 孙磊 on 2018/7/21
     * @apiNote 通过管理员id获取管理员信息
     * @param  mId 管理员id
     * @return  管理员信息
     */
    Manager getManagerById(long mId);
    /**
     * @author 张兴邦 姜志刚 on 2018/7/15
     * @apiNote 获取管理员账户
     * @param  name 管理员名
     * @param password 密码
     * @return  管理员账号
     */
     Manager getManagerByNameAndPassword(String name, String password);
    /**
     * @author 张兴邦 姜志刚 on 2018/7/17
     * @apiNote 更改车价格
     * @param cid 车id
     * @param price 新价格
     * @return  返回执行结果
     */
    boolean changeCarPrice(long cid,String price);
    /**
     * @author 张兴邦 姜志刚 on 2018/7/17
     * @apiNote 更改车状态
     * @param cid 车id
     * @param state 车状态
     * @return  返回执行结果
     */
    boolean changeCarState(long cid,int state);
    /**
     * @author 张兴邦 姜志刚 on 2018/7/13
     * @apiNote  增加一个管理员
     * @param  manager 要增加的管理员
     * @return int 返回执行结果
     */
    boolean addManager(Manager manager);
}
