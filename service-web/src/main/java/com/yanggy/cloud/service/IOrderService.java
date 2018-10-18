package com.yanggy.cloud.service;

import com.yanggy.cloud.dto.OrderDto;
import com.yanggy.cloud.entity.Order;
import com.yanggy.cloud.utils.ResponseEntityDto;

/**
 * @author derrick.yang
 * @Date 10/17/18 11:52
 */
public interface IOrderService {
    ResponseEntityDto<?> getOrders(OrderDto orderDto);
    ResponseEntityDto<?> addOrder(Order order);
    ResponseEntityDto<?> getOrderInfo(Order order);
}
