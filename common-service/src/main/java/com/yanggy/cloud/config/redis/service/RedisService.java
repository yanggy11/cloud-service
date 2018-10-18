package com.yanggy.cloud.config.redis.service;

/**
 * @author derrick.yang
 * @Date 10/17/18 15:47
 */
public interface RedisService {
    String get(String key);
    void set(String key, String value);
    void set(String key, String value, int expire);
    int incr(String key, int moutn);
}
