package com.car.biz;

import com.car.entity.Collect;

import java.util.List;

/**
 * @author 姜志刚&张兴邦 on 2018/7/15
 * @version 1.0
 * @apiNote CollectBiz
 */
public interface CollectBiz {
    /**
     * @author 张兴邦 姜志刚 on 2018/7/13
     * @apiNote  增加一个收藏
     * @param  uid 要增加的收藏的用户id
     * @param cid  要增加的收藏的车辆id
     * @return int 返回执行结果
     */
    boolean addCollect(long uid,long cid);
    /**
     * @author 张兴邦 姜志刚 on 2018/7/13
     * @apiNote  删除一个收藏
     * @param  uid 要删除的收藏的用户id
     * @param cid  要删除的收藏的车辆id
     * @return int 返回执行结果
     */
    boolean removeCollect(long uid,long cid);
    /**
     * @author 张兴邦 姜志刚 on 2018/7/13
     * @apiNote  通过用户id查询数据
     * @param  uid 输入用户id号
     * @return  Collect 返回数据
     */
    List<Collect> getAllCollect(long uid);
}
