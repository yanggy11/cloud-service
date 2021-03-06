package com.yanggy.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

import java.net.SocketException;


/**
 * @author derrick.yang
 * @Date 9/19/18 13:10
 */

@SpringBootApplication
@EnableDiscoveryClient
@EnableConfigServer
public class ServiceConfigCenter {
    public static void main(String[] args) {
        try {
            System.setProperty("local-ip", LocalIp.getIpAddress().getHostAddress());
        } catch (SocketException e) {
            e.printStackTrace();
        }
        SpringApplication.run(ServiceConfigCenter.class, args);
    }
}
