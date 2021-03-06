package com.yanggy.cloud.common.rabbitmq;

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;

/**
 * @author derrick.yang
 * @Date 9/19/18 22:07
 */

//@Configuration
public class RabbitmqConfiguration {

//    @Autowired
    private RabbitmqProperties rabbitmqProperties;

//    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setAddresses(rabbitmqProperties.getAddresses());
        connectionFactory.setUsername(rabbitmqProperties.getUsername());
        connectionFactory.setPassword(rabbitmqProperties.getPassword());
        connectionFactory.setVirtualHost("/");
        connectionFactory.setPublisherConfirms(true); //必须要设置
        
        return connectionFactory;
    }

}
