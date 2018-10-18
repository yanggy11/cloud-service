package com.yanggy.cloud.config.redis;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author derrick.yang
 * @Date 10/17/18 13:38
 */

@ConfigurationProperties
@Component
@Data
public class RedisProperties implements Serializable {

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
}
