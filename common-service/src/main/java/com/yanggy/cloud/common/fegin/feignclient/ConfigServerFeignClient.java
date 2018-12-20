package com.yanggy.cloud.common.fegin.feignclient;

import feign.RequestInterceptor;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author derrick.yang
 * @Date 11/30/18 10:29 AM
 */

@FeignClient(value = "SERVICE-CONFIG-CENTER", configuration = ConfigServerFeignClientConfiguration.class)
public interface ConfigServerFeignClient {
    /**
     * 参数加密
     * @param properties
     * @return
     */
    @PostMapping(value = "decrypt")
    String decrypt(@RequestBody String properties);

    /**
     * 参数解密
     * @param properties
     * @return
     */
    @PostMapping(value = "encrypt")
    String encrypt(@RequestBody String properties);
}

class ConfigServerFeignClientConfiguration {
    @Bean
    public RequestInterceptor headerInterceptor() {
        return (template) -> template.header("Content-Type", "text/plain;charset=UTF-8");
    }
}
