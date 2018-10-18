package com.yanggy.cloud.config.redis;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisSentinelPool;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author derrick.yang
 * @Date 10/17/18 13:45
 */

@Configuration
@ConfigurationProperties
public class RedisSentinelConfig {

    @Value("${redis.database}")
    private String database;
    @Value("${redis.password}")
    private String password;
    @Value("${redis.sentinel.master}")
    private String master;
    @Value("${redis.sentinel.nodes}")
    private String nodes;
    @Value("${redis.pool.max-active}")
    private String maxActive;
    @Value("${redis.pool.max-wait}")
    private String maxWait;
    @Value("${redis.pool.max-idle}")
    private String maxIdle;
    @Value("${redis.pool.min-idle}")
    private String minIdle;
    @Value("${redis.timeout}")
    private String timeout;

    @Bean
    JedisSentinelPool jedisSentinelPool() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(Integer.parseInt(maxIdle));
        jedisPoolConfig.setMaxWaitMillis(Long.parseLong(maxWait));
        jedisPoolConfig.setMinIdle(Integer.parseInt(minIdle));
        jedisPoolConfig.setMaxTotal(Integer.parseInt(maxActive));
        jedisPoolConfig.setTestOnBorrow(true);
        Set<String> sentinels = new HashSet<String>(Arrays.asList(nodes.split(",")));
        JedisSentinelPool jedisSentinelPool = new JedisSentinelPool(master, sentinels, jedisPoolConfig, password);
        return jedisSentinelPool;
    }
}
