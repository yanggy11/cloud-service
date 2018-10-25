package com.yanggy.cloud.kothlin.service.impl;

import com.yanggy.cloud.kothlin.entity.Order
import com.yanggy.cloud.kothlin.entity.Test
import com.yanggy.cloud.kothlin.mapper.TestMapper
import com.yanggy.cloud.kothlin.service.ITestService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 *@author derrick.yang
 *@Date 24/10/2018 16:03
 */

@Service("testService")
class TestServiceImpl : ITestService {
    @Autowired
    lateinit var testMapper: TestMapper

    override fun insertTest(test: Test): Test {
        testMapper.insertTest(test);

        return test
    }

    override fun getOrders(order: Order): MutableList<Order> {
        return testMapper.getORders(order)
    }
}