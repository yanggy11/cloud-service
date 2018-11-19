package com.yang.cloud.actutator;

import com.yang.cloud.actutator.config.LocalIp;
import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.net.SocketException;

@SpringBootApplication
@EnableDiscoveryClient
@EnableAdminServer
public class BootAdminApplication {

    public static void main(String[] args) {
        try {
            System.setProperty("local-ip", LocalIp.getIpAddress().getHostAddress());
        } catch (SocketException e) {
            e.printStackTrace();
        }
        SpringApplication.run(BootAdminApplication.class, args);
    }
}
