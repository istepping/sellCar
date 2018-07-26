package com.car.dao;

import com.car.entity.Collect;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 张兴邦 姜志刚 on 2018/7/13
 * @version 1.0
 * @apiNote collect表访问类
 */
public interface CollectMapper {
    /**
     * @author 张兴邦 姜志刚 on 2018/7/13
     * @apiNote  增加一个收藏
     * @param  uid 要增加的收藏的用户id
     * @param cid  要增加的收藏的车辆id
     * @return int 返回执行结果
     */
    int insertCollect(@Param("uid") long uid,@Param("cid") long cid);
    /**
     * @author 张兴邦 姜志刚 on 2018/7/13
     * @apiNote  删除一个收藏
     * @param  uid 要删除的收藏的用户id
     * @param cid  要删除的收藏的车辆id
     * @return int 返回执行结果
     */
    int deleteCollect(@Param("uid") long uid,@Param("cid") long cid);
    /**
     * @author 张兴邦 姜志刚 on 2018/7/13
     * @apiNote  通过用户id查询数据
     * @param  uid 输入用户id号
     * @return  Collect 返回数据
     */
    List<Collect> queryByuId(@Param("uid") long uid);
}
