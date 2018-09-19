package com.yanggy.cloud;

import com.yanggy.cloud.config.JdbcProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author derrick.yang
 * @Date 9/19/18 09:46
 */

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Autowired
    private JdbcProperties jdbcProperties;


    @GetMapping(value = "/test")
    public Object test() {
        return jdbcProperties;
    }
}
