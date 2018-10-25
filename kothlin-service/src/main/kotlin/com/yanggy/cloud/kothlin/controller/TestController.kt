package com.yanggy.cloud.kothlin.controller;

import com.yanggy.cloud.kothlin.entity.Test
import com.yanggy.cloud.kothlin.service.ITestService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

/**
 *@author derrick.yang
 *@Date 24/10/2018 16:07
 */

@RestController
class TestController {

    @Autowired
    lateinit var testService: ITestService

    @PostMapping(value = "/insert")
    fun insertTest(@RequestBody test: Test): Test {
        return testService.insertTest(test)
    }
}

