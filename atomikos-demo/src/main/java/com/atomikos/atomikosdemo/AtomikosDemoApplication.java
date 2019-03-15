package com.atomikos.atomikosdemo;

import com.atomikos.atomikosdemo.service.AtomikosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class AtomikosDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(AtomikosDemoApplication.class, args);
    }


    @Autowired
    private AtomikosService atomikosService;

    @PostMapping(value = "/test")
    public Object test() {
        return atomikosService.insert();
    }
}

