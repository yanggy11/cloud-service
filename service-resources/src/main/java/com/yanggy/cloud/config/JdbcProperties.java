package com.yanggy.cloud.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author derrick.yang
 * @Date 9/19/18 13:36
 */

@Component
@ConfigurationProperties(prefix = "jdbc")
@Data
public class JdbcProperties {
    private String type;
    private String driver;
    private String url;
    private String username;
    private String root;
    private String password;
    private String initialSize;
    private String minIdle;
    private String maxActive;
    private String maxWait;
    private String timeBetweenEvictionRunsMillis;
    private String minEvictableIdleTimeMillis;
}
