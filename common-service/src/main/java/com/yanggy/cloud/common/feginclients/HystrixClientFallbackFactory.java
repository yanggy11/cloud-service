package com.yanggy.cloud.common.feginclients;

import com.yanggy.cloud.common.dto.vo.RoleVo;
import com.yanggy.cloud.common.dto.vo.UserVo;
import com.yanggy.cloud.common.utils.ResponseEntityBuilder;
import com.yanggy.cloud.common.utils.ResponseEntityDto;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author derrick.yang
 * @Date 11/21/18 9:32 PM
 */

@Component
public class HystrixClientFallbackFactory implements FallbackFactory<ResourceFeiginClient> {
    @Override
    public ResourceFeiginClient create(Throwable cause) {
        return new ResourceFeiginClient() {
            @Override
            public ResponseEntityDto<List<RoleVo>> getAllRoles() {
                return ResponseEntityBuilder.buildErrorResponseEntity("0", cause.getMessage());
            }

            @Override
            public ResponseEntityDto<UserVo> getUserById(Map map) {
                return ResponseEntityBuilder.buildErrorResponseEntity("0", cause.getMessage());
            }
        };
    }
}
