package com.car.dao;

import com.car.entity.Image;

/**
 * @author 孙磊 on 2018/7/19
 * @version 1.0
 * @apiNote 获取其它图片 dao接口
 */
public interface ImageMapper {
    /**
     * @author 孙磊 on 2018/7/19
     * @apiNote 通过车id 获取车其它图片地址
     * @param  cId 车id
     * @return  图片地址存储类
     */
    Image queryById(long cId);
}
