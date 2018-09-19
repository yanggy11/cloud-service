package com.yanggy.cloud;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author derrick.yang
 * @Date 9/19/18 22:20
 */

@RefreshScope
@ConfigurationProperties
@Component
@Data
public class Properties implements Serializable{

    @Value("${config.test}")
    private String test;
}
