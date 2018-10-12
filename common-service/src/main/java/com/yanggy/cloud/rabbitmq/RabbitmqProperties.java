package com.yanggy.cloud.rabbitmq;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author derrick.yang
 * @Date 9/19/18 22:01
 */

@ConfigurationProperties(prefix = "rabbitmq")
@Component
@Data
public class RabbitmqProperties {
    private String addresses;
    private String username;
    private String password;
}
