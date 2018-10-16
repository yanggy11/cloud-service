package com.yanggy.cloud.mapper;

import com.yanggy.cloud.entity.Order;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author derrick.yang
 * @Date 10/16/18 09:43
 */
@Mapper
public interface OrderMapper {
    int insertOrder(Order order);
}
