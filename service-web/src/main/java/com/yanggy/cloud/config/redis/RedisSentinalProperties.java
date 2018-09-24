package com.yanggy.cloud.config.redis;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author: yangguiyun
 * @Date: 2018/1/22 14:10
 * @Description:
 */

@Data
@ConfigurationProperties
@Component
public class RedisSentinalProperties {
    @Value("${redis.database}")
    private String database;

    @Value("${redis.password}")
    private String password;
    @Value("${redis.pool.max-active}")
    private String maxActive;
    @Value("${redis.pool.max-wait}")
    private String maxWait;
    @Value("${redis.pool.max-idle}")
    private String maxIdle;
    @Value("${redis.pool.min-idle}")
    private String minIdl;
//    @Value("${timeout}")
//    private String timeout;
    @Value("${redis.sentinel.nodes}")
    private String sentinelNodes;
    @Value("${redis.sentinel.master}")
    private String masterName;
}
