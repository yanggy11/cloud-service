package com.yanggy.cloud.kothlin.service;

import com.yanggy.cloud.kothlin.entity.Test

/**
 *@author derrick.yang
 *@Date 24/10/2018 16:02
 */
interface ITestService {
    fun insertTest(test: Test): Test
}