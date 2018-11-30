package com.yanggy.cloud.common.fegin.fallback;

import com.yanggy.cloud.common.dto.vo.UserVo;
import com.yanggy.cloud.common.fegin.feignclient.ResourceFeiginClient;
import com.yanggy.cloud.common.utils.ResponseEntityBuilder;
import com.yanggy.cloud.common.utils.ResponseEntityDto;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author derrick.yang
 * @Date 11/21/18 9:32 PM
 */

@Component
public class ResourceHystrixClientFallbackFactory implements FallbackFactory<ResourceFeiginClient> {
    private final static Logger logger = LoggerFactory.getLogger(ResourceHystrixClientFallbackFactory.class);
    @Override
    public ResourceFeiginClient create(Throwable cause) {
        return new ResourceFeiginClient() {
            @Override
            public ResponseEntityDto<UserVo> getUserById(Map map) {
                logger.info("查询用户信息发生错误，请求参数：{},错误信息：{}", map, cause.getMessage());
                return ResponseEntityBuilder.buildErrorResponseEntity("0", cause.getMessage());
            }
        };
    }
}
