package com.yanggy.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author derrick.yang
 * @Date 9/19/18 09:31
 */

@SpringBootApplication
@EnableEurekaServer
public class ServiceCenter {
    public static void main(String[] args) {
        SpringApplication.run(ServiceCenter.class, args);
    }
}
