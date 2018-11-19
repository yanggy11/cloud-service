package com.yanggy.cloud.kothlin

import com.yanggy.cloud.kothlin.utils.LocalIp
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
class KothlinServiceApplication

fun main(args: Array<String>) {
    System.setProperty("local-ip", LocalIp.getHostAdress().hostAddress);
    runApplication<KothlinServiceApplication>(*args)
}
