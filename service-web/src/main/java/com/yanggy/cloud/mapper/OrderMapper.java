package com.yanggy.cloud.mapper;

import com.yanggy.cloud.dto.OrderDto;
import com.yanggy.cloud.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author derrick.yang
 * @Date 10/16/18 09:43
 */
@Mapper
public interface OrderMapper {

    int insertOrder(Order order);

    List<Order> getOrders(OrderDto orderDto);

    int count(OrderDto orderDto);

    Order getOrderInfo(@Param("id") Long id);
}
