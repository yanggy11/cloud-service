package com.yanggy.cloud.common;

import com.yanggy.cloud.common.utils.LocalIp;
import org.slf4j.MDC;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.net.InetAddress;
import java.net.SocketException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableCircuitBreaker
public class CommonServiceApplication {

    public static void main(String[] args) {
        try {
            System.setProperty("local-ip", LocalIp.getIpAddress().getHostAddress());
        } catch (SocketException e) {
            e.printStackTrace();
        }
        SpringApplication.run(CommonServiceApplication.class, args);
    }

    @Bean
    public ExecutorService getThreadPool(){
        return Executors.newFixedThreadPool(100);
    }

    public static String getLocalHostIP() {
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
