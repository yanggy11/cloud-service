package com.yanggy.cloud.config.redis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisSentinelPool;

/**
 * @author derrick.yang
 * @Date 10/17/18 15:48
 */

@Component("redisService")
public class RedisServiceImpl implements RedisService {
    @Autowired
    private JedisSentinelPool jedisPool;
    private Jedis getJedis() {
        return jedisPool.getResource();
    }
    @Override
    public String get(String key) {
        Jedis jedis = null;
        String value = null;
        try {
            jedis = this.getJedis();
            value = jedis.get(key);
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(null != jedis) {
                jedis.close();
            }
        }
        return value;
    }
    @Override
    public void set(String key, String value) {
        Jedis jedis = null;
        try {
            jedis = this.getJedis();
            jedis.set(key, value);
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(null != jedis) {
                jedis.close();
            }
        }
    }
    @Override
    public void set(String key, String value, int expire) {
        Jedis jedis = null;
        try {
            jedis = this.getJedis();
            jedis.set(key, value);
            jedis.expire(key, expire);
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(null != jedis) {
                jedis.close();
            }
        }
    }
    @Override
    public int incr(String key, int mount) {
        Jedis jedis = null;
        try {
            jedis = this.getJedis();
            jedis.incrBy(key, mount);
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(null != jedis) {
                jedis.close();
            }
        }
        return Integer.parseInt(jedis.get(key));
    }
}
