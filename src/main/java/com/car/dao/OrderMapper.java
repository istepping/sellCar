package com.car.dao;

import com.car.entity.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 张兴邦 姜志刚 on 2018/7/13
 * @version 1.0
 * @apiNote order表访问类
 */

public interface OrderMapper {
    /**
     * @author 张兴邦 姜志刚 on 2018/7/13
     * @apiNote  通过订单id查询数据
     * @param  id 输入订单id号
     * @return  Order 返回数据
     */
    Order queryById(long id);
    /**
     * @author 张兴邦 姜志刚 on 2018/7/13
     * @apiNote  通过用户姓名查询数据
     * @param  uId 输入用户id
     * @return  Order 返回数据
     */
    List<Order> queryByUserId(long uId);
    /**
     * @author 张兴邦 姜志刚 on 2018/7/13
     * @apiNote  查询所有订单信息
     * @return  返回所有订单集合
     */
    List<Order> queryAll();
    /**
     * @author 张兴邦 姜志刚 on 2018/7/13
     * @apiNote  增加一个订单
     * @param  uId 用户ID
     * @param  cId 车ID
     * @return int 执行结果
     */
    int insertOrder(@Param("uId") long uId,@Param("cId") long cId);
    /**
     * @author 张兴邦 姜志刚 on 2018/7/13
     * @apiNote  删除一个订单
     * @param  id 要删除的订单id
     * @return int 返回执行结果
     */
    int deleteOrder(long id);
    /**
     * @author 张兴邦 姜志刚 on 2018/7/13
     * @apiNote  通过订单id修改订单状态
     * @param  id 输入订单id号
     * @param state 输入订单状态
     * @return int 返回执行结果
     */
    int updateOrderState(@Param("id") long id,@Param("state") int state);
}
