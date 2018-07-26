package com.car.biz;

import com.car.dao.OrderMapper;
import com.car.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.car.utils.StaticMethod.logger;

/**
 * @author 孙磊 on 2018/7/15
 * @version 1.0
 * @apiNote 订单接口实现
 */
@Component
public class OrderBizIml implements OrderBiz {
    @Autowired
    private OrderMapper orderMapper;
    @Override
    public List<Order> getAllOrder() {
        return orderMapper.queryAll();
    }
    @Override
    public List<Order> getOrder(long uid){
        return orderMapper.queryByUserId(uid);
    }
    @Override
    public boolean addOrder(long uid,long cid){
        int result = orderMapper.insertOrder(uid,cid);
        logger.info(this.getClass()+"result"+result);
        if(result>0){
            return true;
        }
        else {
            return false;
        }
    }
    @Override
    public boolean removeOrder(long id){
        int result = orderMapper.deleteOrder(id);
        logger.info(this.getClass()+"result"+result);
        if(result>0){
            return true;
        }
        else {
            return false;
        }
    }
    @Override
    public boolean changeOrderState(long oid,int state){
        int result=orderMapper.updateOrderState(oid,state);
        if(result>0){
            return true;
        }
        else {
            return false;
        }
    }
    @Override
    public Order getOrderInfo(long oid){
        return orderMapper.queryById(oid);
    }
}
