package com.car.biz;

import com.car.dao.ImageMapper;
import com.car.entity.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author 孙磊 on 2018/7/19
 * @version 1.0
 * @apiNote
 */
@Component
public class ImageBizIml implements ImageBiz {
    @Autowired
    private ImageMapper imageMapper;
    @Override
    public Image getImageById(long cId) {
        return imageMapper.queryById(cId);
    }
}
