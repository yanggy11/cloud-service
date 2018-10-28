package com.yanggy.cloud.kothlin.mapper;

import com.yanggy.cloud.kothlin.entity.Test
import org.apache.ibatis.annotations.Mapper
import org.springframework.stereotype.Component

/**
 *@author derrick.yang
 *@Date 24/10/2018 15:58
 */

@Mapper
@Component
interface TestMapper {
    fun insertTest(test: Test): Int
}