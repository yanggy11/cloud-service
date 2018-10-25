package com.yanggy.cloud.mapper;

import com.yanggy.cloud.dto.OrderDto;
import com.yanggy.cloud.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author derrick.yang
 * @Date 10/16/18 09:43
 */
@Component
@Mapper
public interface OrderMapper {

    int insertOrder(Order order);

    List<Order> getOrders(OrderDto orderDto);

    int count(OrderDto orderDto);

    Order getOrderInfo(@Param("id") Long id);
}
