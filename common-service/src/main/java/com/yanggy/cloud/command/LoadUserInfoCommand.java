package com.yanggy.cloud.command;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author derrick.yang
 * @Date 10/17/18 13:32
 */

@Component
@Order(2)
public class LoadUserInfoCommand implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("加载数据");
    }
}
