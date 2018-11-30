package com.yanggy.cloud.common.mapper;

import com.yanggy.cloud.common.entity.ConfigFile;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author derrick.yang
 * @Date 11/28/18 4:57 PM
 */

@Mapper
@Component
public interface ConfigFileMapper {
    List<ConfigFile> getConfigFileByAppId(@Param("appId") int appid);
}
