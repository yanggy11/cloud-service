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
 * @Date 9/23/18 10:21
 */

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class CommonService {
    @Bean
    public ExecutorService getThreadPool(){
        return Executors.newFixedThreadPool(100);
    }

    public static void main(String[] args) {
        SpringApplication.run(CommonService.class, args);
    }
}
