package com.yanggy.cloud.common.fegin.fallback;

import com.yanggy.cloud.common.config.enums.ErrorCode;
import com.yanggy.cloud.common.dto.vo.UserVo;
import com.yanggy.cloud.common.fegin.feignclient.ResourceFeiginClient;
import com.yanggy.cloud.common.utils.ResponseEntityBuilder;
import com.yanggy.cloud.common.utils.ResponseEntityDto;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author derrick.yang
 * @Date 11/19/18 10:41 PM
 */

@Component
public class ResourceFeignFallback implements ResourceFeiginClient {
    @Override
    public ResponseEntityDto<UserVo> getUserById(Map map) {
        return ResponseEntityBuilder.buildErrorResponseEntity(ErrorCode.DEFAULT_METHOD);
    }
}
