package com.flycat.dao.base;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by flycat on 2018/7/20.
 */
@Repository
@Component
public class BaseDao {
    @Autowired
    private RedisTemplate redisTemplate;

    public void putHash(String mapKey,String field,String value){
        if(null!=mapKey && !"".equals(mapKey)){
            try {
                HashOperations<String,String,String> hashOperations = redisTemplate.opsForHash();
                hashOperations.put(mapKey,field,value);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public String getHash(String mapKey,String field){
        String result = "";
        if(null!=mapKey && !"".equals(mapKey)){
            try {
                HashOperations<String,String,String> hashOperations = redisTemplate.opsForHash();
                result = hashOperations.get(mapKey,field);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
