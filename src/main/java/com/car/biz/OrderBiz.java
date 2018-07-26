package com.car.biz;

import com.car.entity.Order;

import java.util.List;

/**
 * @author 孙磊 on 2018/7/15
 * @version 1.0
 * @apiNote 订单接口
 */
public interface OrderBiz {
    /**
     * @author 孙磊 on 2018/7/15
     * @apiNote 返回全部订单
     * @return  订单
     */
    List<Order> getAllOrder();
    /**
     * @author 张兴邦 姜志刚 on 2018/7/16
     * @apiNote 查看订单
     * @param  uid 用户id
     * @return  返回执行结果
     */
    List<Order> getOrder(long uid);
    /**
     * @author 张兴邦 姜志刚 on 2018/7/15
     * @apiNote  增加一个订单
     * @param  uid 用户ID
     * @param  cid 车ID
     * @return int 执行结果
     */
    boolean addOrder(long uid,long cid);
    /**
     * @author 张兴邦 姜志刚 on 2018/7/13
     * @apiNote  删除一个订单
     * @param  id 要删除的订单id
     * @return int 返回执行结果
     */
    boolean removeOrder(long id);
    /**
     * @author 张兴邦 姜志刚 on 2018/7/16
     * @apiNote 付款
     * @param  state 状态
     * @param oid 订单id
     * @return  返回执行结果
     */
    boolean changeOrderState(long oid,int state);
    /**
     * @author 张兴邦 姜志刚 on 2018/7/16
     * @apiNote 查看订单
     * @param  oid 订单id
     * @return  返回执行结果
     */
    Order getOrderInfo(long oid);
}
