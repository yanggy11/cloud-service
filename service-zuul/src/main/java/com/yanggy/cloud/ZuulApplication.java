package com.yanggy.cloud;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.yanggy.cloud.config.filters.PreRequestFilter;

/**
 * @author derrick.yang
 * @Date 9/19/18 14:47
 */


@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
@RestController
public class ZuulApplication {
	
	@Value("${jwt.header}")
	private String auth_header;
    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication.class, args);
    }

    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public PreRequestFilter zuulFilter() {
        PreRequestFilter zuulFilter = new PreRequestFilter(restTemplate());
        zuulFilter.setAuthHeader(auth_header);
        
        return zuulFilter;
    }
}
