package com.yanggy.cloud.config.rabbitmq;

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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

        CachingConnectionFactory connection = new CachingConnectionFactory();

        connection.setUsername(rabbitmqProperties.getUsername());
        connection.setAddresses(rabbitmqProperties.getAddresses());
        connection.setPassword(rabbitmqProperties.getPassword());
        connection.setVirtualHost("/");
        connection.setPublisherConfirms(true); //必须要设置

        return connection;
    }

}
