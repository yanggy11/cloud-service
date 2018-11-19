package com.yanggy.cloud;

import com.yanggy.cloud.config.LocalIp;
import org.slf4j.MDC;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.net.InetAddress;
import java.net.SocketException;

/**
 * @author derrick.yang
 * @Date 9/19/18 14:47
 */


@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
@EnableFeignClients
public class ZuulApplication {
    public static void main(String[] args) {
        try {
            System.setProperty("local-ip", LocalIp.getIpAddress().getHostAddress());
        } catch (SocketException e) {
            e.printStackTrace();
        }
        SpringApplication.run(ZuulApplication.class, args);
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
