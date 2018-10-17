package com.yanggy.cloud.feigin;

import com.yanggy.cloud.dto.feigin.UserDto;
import com.yanggy.cloud.utils.ResponseEntityDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author derrick.yang
 * @Date 10/17/18 11:02
 */

@FeignClient(name = "RESOURCES", configuration = FeginRequestInterceptor.class)
public interface ResourcesFeiginClient {
    @PostMapping(value="/user/getUserById")
    ResponseEntityDto<UserDto> getUserInfo(UserDto userDto);
}
