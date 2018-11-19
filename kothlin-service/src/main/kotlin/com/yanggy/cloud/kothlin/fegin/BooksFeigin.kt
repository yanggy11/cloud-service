package com.yanggy.cloud.kothlin.fegin;

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.RequestMapping

/**
 *@author derrick.yang
 *@Date 11/16/18 9:36 AM
 */

@FeignClient(name = "sidecar")
interface BooksFeigin {
    @RequestMapping(value="/books")
    fun getBooks(): Any
}