package com.yanggy.cloud.common.fegin.fallback;

import com.yanggy.cloud.common.fegin.feignclient.ConfigServerFeignClient;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author derrick.yang
 * @Date 11/30/18 4:34 PM
 */

@Component
public class ConfigServerFeignClientFallbackFactory implements FallbackFactory<ConfigServerFeignClient> {
    private Logger logger = LoggerFactory.getLogger(ConfigServerFeignClientFallbackFactory.class);
    @Override
    public ConfigServerFeignClient create(Throwable cause) {
        return new ConfigServerFeignClient() {
            @Override
            public String decrypt(String properties) {
                logger.error("配置信息解密失败，密文:{},错误:{}", properties, cause.getMessage());
                return "";
            }

            @Override
            public String encrypt(String properties) {
                logger.error("配置信息加密失败，明文:{},错误:{}", properties, cause.getMessage());
                return "";
            }
        };
    }
}
