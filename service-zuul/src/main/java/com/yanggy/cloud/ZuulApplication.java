package com.yanggy.cloud;

import com.yanggy.cloud.config.filters.ZuulFilterTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author derrick.yang
 * @Date 9/19/18 14:47
 */


@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
@RestController
@RibbonClient
public class ZuulApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication.class, args);
    }

    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public ZuulFilterTest zuulFilterTest() {
        ZuulFilterTest zuulFilterTest = new ZuulFilterTest(restTemplate());

        return zuulFilterTest;
    }

}
