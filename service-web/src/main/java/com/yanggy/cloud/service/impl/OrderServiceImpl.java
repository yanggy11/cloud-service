package com.yanggy.cloud.service.impl;

import com.yanggy.cloud.dto.OrderDto;
import com.yanggy.cloud.dto.vo.OrderVo;
import com.yanggy.cloud.dto.vo.UserVo;
import com.yanggy.cloud.entity.Order;
import com.yanggy.cloud.feginclients.ResourceFeiginClient;
import com.yanggy.cloud.mapper.OrderMapper;
import com.yanggy.cloud.service.IOrderService;
import com.yanggy.cloud.utils.ResponseEntityBuilder;
import com.yanggy.cloud.utils.ResponseEntityDto;
import io.shardingsphere.api.HintManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author derrick.yang
 * @Date 10/17/18 11:53
 */

@Service("orderService")
public class OrderServiceImpl implements IOrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private ResourceFeiginClient resourceFeiginClient;

    @Override
    public ResponseEntityDto<?> getOrders(OrderDto orderDto) {

        Map<String, Object> data  = new HashMap<>();
        int count = orderMapper.count(orderDto);

        data.put("count", count);
        int offset = (orderDto.getPage() - 1) * orderDto.getPageSize();
        orderDto.setOffset(offset);

        List<Order> orders = orderMapper.getOrders(orderDto);

        List<OrderVo> orderVos = orders.parallelStream().
                map(order -> this.getOrderVo(order)).
                collect(Collectors.toList());

        data.put("orders", orderVos);

        return ResponseEntityBuilder.buildNormalResponseEntity(data);
    }

    private OrderVo getOrderVo(Order order) {
        OrderVo orderVo = new OrderVo();
        orderVo.setId(order.getId());
        orderVo.setUserId(order.getUserId());
        orderVo.setOrderTime(order.getCreateTime());
        Map map = new HashMap();
        map.put("userId", order.getUserId());
        ResponseEntityDto<UserVo> res = resourceFeiginClient.getUserById(map);
        if(null != res && null != res.getData()) {
            UserVo userVo = res.getData();
            orderVo.setEmail(userVo.getEmail());
            orderVo.setName(userVo.getName());
            orderVo.setPhone(userVo.getPhone());
        }
        return orderVo;
    }

    @Override
    public ResponseEntityDto<?> addOrder(Order order) {
        HintManager hintManager = HintManager.getInstance();
        hintManager.setMasterRouteOnly();
        orderMapper.insertOrder(order);
        Order order1 = orderMapper.getOrderInfo(order.getId());

        System.out.println(order1);

        hintManager.close();
        return ResponseEntityBuilder.buildNormalResponseEntity(order1);
    }

    @Override
    public ResponseEntityDto<?> getOrderInfo(Order order) {
        return ResponseEntityBuilder.buildNormalResponseEntity(orderMapper.getOrderInfo(order.getId()));
    }
}
