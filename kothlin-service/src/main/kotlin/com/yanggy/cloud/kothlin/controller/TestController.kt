package com.yanggy.cloud.kothlin.controller;

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

/**
 *@author derrick.yang
 *@Date 24/10/2018 16:07
 */

@RestController
class TestController {


    @PostMapping(value = "/insert")
    fun insertTest(): String {
        return "hello, kothilin"
    }
    @PostMapping(value = "/testFallback")
    fun testFallback(): String {
        return "hello, kothilin"
    }
}

