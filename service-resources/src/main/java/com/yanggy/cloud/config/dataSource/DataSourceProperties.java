package com.yanggy.cloud.config.dataSource;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * Created by yangguiyun on 2017/9/21.
 */


@Data
@Component
@ConfigurationProperties(prefix = DataSourceProperties.PREFIX, ignoreUnknownFields = false)
public class DataSourceProperties {
    public final static String PREFIX="jdbc";

    private String type;
    private String driver;
    private String url;
    private String username;
    private String password;
    private int initialSize;
    private int minIdle;
    private int maxActive;
    private int maxWait;
    private int timeBetweenEvictionRunsMillis;
    private int minEvictableIdleTimeMillis;
}
