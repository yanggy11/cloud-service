package com.yanggy.cloud.config.redis;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisSentinelPool;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author derrick.yang
 * @Date 8/28/18 15:06
 */

@Configuration
@Data
public class RedisSentinalConfiguration {

    @Autowired
    private RedisSentinalProperties redisSentinalProperties;

    @Bean
    JedisSentinelPool jedisSentinelPool() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();

        jedisPoolConfig.setMaxIdle(Integer.parseInt(redisSentinalProperties.getMaxIdle()));
        jedisPoolConfig.setMaxWaitMillis(Long.parseLong(redisSentinalProperties.getMaxWait()));
        jedisPoolConfig.setMinIdle(Integer.parseInt(redisSentinalProperties.getMinIdl()));
        jedisPoolConfig.setMaxTotal(Integer.parseInt(redisSentinalProperties.getMaxActive()));
        jedisPoolConfig.setTestOnBorrow(true);


        Set<String> sentinels = new HashSet<String>(Arrays.asList(redisSentinalProperties.getSentinelNodes().split(",")));
        JedisSentinelPool jedisSentinelPool = new JedisSentinelPool(redisSentinalProperties.getMasterName(), sentinels, jedisPoolConfig, redisSentinalProperties.getPassword());

        return jedisSentinelPool;
    }
}
