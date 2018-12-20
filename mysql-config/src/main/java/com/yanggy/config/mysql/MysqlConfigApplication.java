package com.yanggy.config.mysql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@EnableConfigServer
@EnableDiscoveryClient
@SpringBootApplication
public class MysqlConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(MysqlConfigApplication.class, args);
    }
}
