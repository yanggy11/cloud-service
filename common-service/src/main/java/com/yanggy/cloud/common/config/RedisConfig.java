package com.yanggy.cloud.common.config;

import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author derrick.yang
 * @Date 10/31/18 9:40 AM
 */

@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {
    @Bean
    public RedisCacheManager cacheManager(RedisConnectionFactory connectionFactory) {
        return RedisCacheManager.builder(connectionFactory).build();
    }

//    @Bean
//    public RedisConnectionFactory connectionFactory() {
//        return new JedisConnectionFactory();
//    }

    @Bean
    public RedisTemplate<?, ?> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<byte[], byte[]> template = new RedisTemplate<byte[], byte[]>();
        template.setConnectionFactory(redisConnectionFactory);
        return template;
    }
}
