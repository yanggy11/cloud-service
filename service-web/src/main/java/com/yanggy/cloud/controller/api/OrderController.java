package com.yanggy.cloud.controller.api;

import com.yanggy.cloud.dto.OrderDto;
import com.yanggy.cloud.entity.Order;
import com.yanggy.cloud.service.IOrderService;
import com.yanggy.cloud.utils.ResponseEntityDto;
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
    private IOrderService orderService;

    @PostMapping(value = "add")
    public ResponseEntityDto<?> addOrder(@RequestBody Order order) {

        return orderService.addOrder(order);
    }

    @PostMapping(value = "userOrders")
    public ResponseEntityDto<?> getOrdersByUserId(@RequestBody OrderDto order) {

        return orderService.getOrders(order);
    }
}
