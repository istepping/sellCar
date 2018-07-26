package com.car.dao.cache;

import com.car.entity.Car;
import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.ProtobufIOUtil;
import com.dyuproject.protostuff.runtime.RuntimeSchema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @author 孙磊 on 2018/7/13
 * @version 1.0
 * @apiNote Redis缓存
 */
public class Redis {
    private final Logger logger= (Logger) LoggerFactory.getLogger(this.getClass());
    //连接池,连接资源,构造函数，set,get函数
    private final JedisPool jedisPool;
    private RuntimeSchema<Car> schema=RuntimeSchema.createFrom(Car.class);
    public Redis(String ip,int port)
    {
        jedisPool=new JedisPool(ip,port);
    }
    //序列化和反序列化:
    private byte[] serialize(Car car) {
        //默认大小的缓冲区
        LinkedBuffer buffer=LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE);
        try{
            return ProtobufIOUtil.toByteArray(car,schema,buffer);
        }catch (Exception e)
        {
            logger.error(e.getMessage(),e);
        }finally {
            buffer.clear();
        }
        return null;
    }
    private Car deSerialize(byte[] data) {
        try{
            Car car=schema.newMessage();
            ProtobufIOUtil.mergeFrom(data,car,schema);
            return car;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
        }
        return null;
    }
    //set,get操作
    public String set(Car car) {
        Jedis jedis=jedisPool.getResource();
        String key="goods"+car.getcId();
        int timeout=60*60;
        return jedis.setex(key.getBytes(),timeout,serialize(car));
    }
    public Car get(long id) {
        Jedis jedis=jedisPool.getResource();
        String key="goods"+id;
        byte[] bytes=jedis.get(key.getBytes());
        if(bytes!=null)
        {
            return deSerialize(bytes);
        }
        else
        {
            return null;
        }
    }
}
