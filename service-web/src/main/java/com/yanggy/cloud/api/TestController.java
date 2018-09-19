package com.yanggy.cloud.api;

import com.yanggy.cloud.Properties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author derrick.yang
 * @Date 9/19/18 15:34
 */

@RestController
public class TestController {

    @Autowired
    private Properties properties;

    @GetMapping(value = "/test")
    public Object test() {
        return properties.getTest();
    }
}
