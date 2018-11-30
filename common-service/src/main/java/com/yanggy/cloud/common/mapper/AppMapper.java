package com.yanggy.cloud.common.mapper;

import com.yanggy.cloud.common.entity.App;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author derrick.yang
 * @Date 11/28/18 4:58 PM
 */

@Mapper
@Component
public interface AppMapper {
    List<App> getApps(@Param("offset") int offset, @Param("size") int size);
}
