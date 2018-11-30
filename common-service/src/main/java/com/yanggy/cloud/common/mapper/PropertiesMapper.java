package com.yanggy.cloud.common.mapper;

import com.yanggy.cloud.common.entity.Properties;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author derrick.yang
 * @Date 11/29/18 4:08 PM
 */

@Component
@Mapper
public interface PropertiesMapper {
    List<Properties>getPropertes(Properties properties);
}
