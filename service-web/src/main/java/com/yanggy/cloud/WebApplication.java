package com.yanggy.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author derrick.yang
 * @Date 9/19/18 13:50
 */

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class WebApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class);
    }

    @Bean
    public ExecutorService getThreadPool(){
        return Executors.newFixedThreadPool(100);
    }
}
