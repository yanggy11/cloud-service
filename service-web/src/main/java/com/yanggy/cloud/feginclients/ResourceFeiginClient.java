package com.yanggy.cloud.feginclients;

import com.yanggy.cloud.utils.ResponseEntityDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Map;

/**
 * @author derrick.yang
 * @Date 9/23/18 11:41
 */

@FeignClient(value = "resources",configuration = FeiginConfiguration.class)
public interface ResourceFeiginClient {
    @PostMapping(value="/role/getAllRoles")
    ResponseEntityDto<List<Map>> getAllRoles();

    @PostMapping(value="/user/getUserById")
    ResponseEntityDto<Map> getUserById(Map map);
}
