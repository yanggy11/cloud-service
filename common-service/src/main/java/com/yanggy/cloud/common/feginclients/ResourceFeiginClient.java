package com.yanggy.cloud.common.feginclients;


import com.yanggy.cloud.common.dto.vo.UserVo;
import com.yanggy.cloud.common.utils.ResponseEntityDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Map;

/**
 * @author derrick.yang
 * @Date 9/23/18 11:41
 */

@Component
@FeignClient(value = "RESOURCES",configuration = FeiginConfiguration.class, fallback = FallbackService.class)
public interface ResourceFeiginClient {
    @PostMapping(value="/role/getAllRoles")
    ResponseEntityDto<List<Map>> getAllRoles();

    @PostMapping(value="/user/getUserById")
    ResponseEntityDto<UserVo> getUserById(Map map);
}
