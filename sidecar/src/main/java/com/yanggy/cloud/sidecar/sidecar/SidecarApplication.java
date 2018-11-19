package com.yanggy.cloud.sidecar.sidecar;

import com.yanggy.cloud.sidecar.sidecar.config.LocalIp;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.sidecar.EnableSidecar;

import java.net.SocketException;

@SpringBootApplication
@EnableSidecar
public class SidecarApplication {

    public static void main(String[] args) {
        try {
            System.setProperty("local-ip", LocalIp.getIpAddress().getHostAddress());
        } catch (SocketException e) {
            e.printStackTrace();
        }
        SpringApplication.run(SidecarApplication.class, args);
    }
}
