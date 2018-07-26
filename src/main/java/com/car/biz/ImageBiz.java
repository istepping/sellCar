package com.car.biz;

import com.car.entity.Image;

/**
 * @author 孙磊 on 2018/7/19
 * @version 1.0
 * @apiNote
 */
public interface ImageBiz {
    /**
     * @author 孙磊 on 2018/7/19
     * @apiNote 获取图片地址信息
     * @param  cId 车id
     * @return  地址信息类
     */
    Image getImageById(long cId);
}
