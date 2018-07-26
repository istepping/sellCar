package com.car.biz;

import com.car.dao.CollectMapper;
import com.car.entity.Collect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.car.utils.StaticMethod.logger;
@Component
public class CollectBizIml implements CollectBiz {
    @Autowired
    CollectMapper collectMapper;
    @Override
    public boolean addCollect(long uid,long cid){
        //查询数据库,重复收藏则返回
        List<Collect> collects=collectMapper.queryByuId(uid);
        for(int i=0;i<collects.size();i++){
            if(cid==collects.get(i).getcId()){
                return false;
            }
        }
        int result = collectMapper.insertCollect(uid,cid);
        logger.info(this.getClass()+"result"+result);
        if(result>0){
            return true;
        }
        else {
            return false;
        }
    }
    @Override
    public boolean removeCollect(long uid,long cid){
        int result = collectMapper.deleteCollect(uid,cid);
        logger.info(this.getClass()+"result"+result);
        if(result>0){
            return true;
        }
        else {
            return false;
        }
    }
    @Override
    public List<Collect> getAllCollect(long uid){
        return collectMapper.queryByuId(uid);
    }
}
