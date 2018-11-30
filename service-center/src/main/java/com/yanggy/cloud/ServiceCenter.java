package com.yanggy.cloud;

import com.yanggy.cloud.config.LocalIp;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Bean;

import javax.servlet.*;
import java.io.IOException;
import java.net.SocketException;

/**
 * @author derrick.yang
 * @Date 9/19/18 09:31
 */

@SpringBootApplication
@EnableEurekaServer
public class ServiceCenter {
    public static void main(String[] args) {
        try {
            System.setProperty("local-ip", LocalIp.getIpAddress().getHostAddress());
        } catch (SocketException e) {
            e.printStackTrace();
        }
        SpringApplication.run(ServiceCenter.class, args);
    }
}
