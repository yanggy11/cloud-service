package com.atomikos.atomikosdemo.dao1;

import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

/**
 * @author derrick.yang
 * @Date 12/25/18 11:05 AM
 */

@Mapper
public interface WebMapper {
    int insert(Map map);
}
