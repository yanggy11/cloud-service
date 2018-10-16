package com.yanggy.cloud.controller.api;

import com.yanggy.cloud.entity.Order;
import com.yanggy.cloud.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author derrick.yang
 * @Date 10/16/18 12:11
 */

@RestController
@RequestMapping("/order/")
public class OrderController {

    @Autowired
    private OrderMapper orderMapper;
    @PostMapping(value = "add")
    public Order addOrder(@RequestBody Order order) {
        orderMapper.insertOrder(order);

        return order;
    }
}
