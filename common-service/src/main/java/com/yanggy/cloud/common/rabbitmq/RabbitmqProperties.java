package com.yanggy.cloud.common.rabbitmq;

import lombok.Data;

/**
 * @author derrick.yang
 * @Date 9/19/18 22:01
 */

//@ConfigurationProperties(prefix = "rabbitmq")
//@Component
@Data
public class RabbitmqProperties {
    private String addresses;
    private String username;
    private String password;
}
