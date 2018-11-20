package com.yanggy.cloud.common.feginclients;

import com.yanggy.cloud.common.config.enums.ErrorCode;
import com.yanggy.cloud.common.dto.vo.UserVo;
import com.yanggy.cloud.common.utils.ResponseEntityBuilder;
import com.yanggy.cloud.common.utils.ResponseEntityDto;

import java.util.List;
import java.util.Map;

/**
 * @author derrick.yang
 * @Date 11/19/18 10:41 PM
 */

//@Component
public class ResourceFeignFallback implements ResourceFeiginClient {
    @Override
    public ResponseEntityDto<List<Map>> getAllRoles() {
        return ResponseEntityBuilder.buildErrorResponseEntity(ErrorCode.DEFAULT_METHOD);
    }

    @Override
    public ResponseEntityDto<UserVo> getUserById(Map map) {
        return ResponseEntityBuilder.buildErrorResponseEntity(ErrorCode.DEFAULT_METHOD);
    }
}
