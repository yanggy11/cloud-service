package com.yanggy.cloud.service.impl;

import com.yanggy.cloud.dto.OrderDto;
import com.yanggy.cloud.entity.Order;
import com.yanggy.cloud.mapper.OrderMapper;
import com.yanggy.cloud.service.IOrderService;
import com.yanggy.cloud.utils.ResponseEntityBuilder;
import com.yanggy.cloud.utils.ResponseEntityDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author derrick.yang
 * @Date 10/17/18 11:53
 */

@Service("orderService")
public class OrderServiceImpl implements IOrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Override
    public ResponseEntityDto<?> getOrders(OrderDto orderDto) {
        Map<String, Object> data  = new HashMap<>();
        int count = orderMapper.count(orderDto);

        data.put("count", count);
        data.put("orders", orderMapper.getOrders(orderDto));

        return ResponseEntityBuilder.buildNormalResponseEntity(data);
    }

    @Override
    public ResponseEntityDto<?> addOrder(Order order) {
        orderMapper.insertOrder(order);
        return ResponseEntityBuilder.buildNormalResponseEntity();
    }

    @Override
    public ResponseEntityDto<?> getOrderInfo(Order order) {
        return ResponseEntityBuilder.buildNormalResponseEntity(orderMapper.getOrderInfo(order.getId()));
    }
}
