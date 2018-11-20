package com.yanggy.cloud.kothlin.controller;

import com.yanggy.cloud.kothlin.fegin.BooksFeigin
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

/**
 *@author derrick.yang
 *@Date 24/10/2018 16:07
 */

@RestController
class TestController {


    @Autowired
    lateinit var booksFeigin: BooksFeigin;
    @PostMapping(value = "/insert")
    fun insertTest(): Any {
        return booksFeigin.getBooks()
    }
    @PostMapping(value = "/testFallback")
    fun testFallback(): String {
        return "hello, kothilin"
    }
}

