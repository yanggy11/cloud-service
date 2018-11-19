package com.yanggy.cloud;

import com.yanggy.cloud.config.LocalIp;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.MDC;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.net.InetAddress;
import java.net.SocketException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author derrick.yang
 * @Date 9/19/18 09:46
 */

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@MapperScan(basePackages = "com.yang.cloud.mapper")
public class Application {
    public static void main(String[] args) {
        try {
            System.setProperty("local-ip", LocalIp.getIpAddress().getHostAddress());
        } catch (SocketException e) {
            e.printStackTrace();
        }
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public ExecutorService getThreadPool(){
        return Executors.newFixedThreadPool(100);
    }

    private static String getLocalHostIP() {
        String ip;
        try {
            /**返回本地主机。*/
            InetAddress addr = InetAddress.getLocalHost();
            /**返回 IP 地址字符串（以文本表现形式）*/
            ip = addr.getHostAddress();
        } catch(Exception ex) {
            ip = "127.0.0.1";
        }

        return ip;
    }
}
