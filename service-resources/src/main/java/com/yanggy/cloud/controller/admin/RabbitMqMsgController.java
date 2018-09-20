package com.yanggy.cloud.controller.admin;

import com.yanggy.cloud.param.RabbitMqMsgParam;
import com.yanggy.cloud.service.IRabbitMqMsgService;
import com.yanggy.cloud.utils.ResponseEntityDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author derrick.yang
 * @Date 9/8/18 15:20
 */

@RestController
@RequestMapping(value = "/rabbit/msg/**")
public class RabbitMqMsgController {

    @Autowired
    private IRabbitMqMsgService rabbitMqMsgService;
    @PostMapping(value = "getRabbitMsg")
    public ResponseEntityDto<?> getRabbitMsg(@RequestBody RabbitMqMsgParam rabbitMqMsgParam) {
        return rabbitMqMsgService.getRabbitMsg(rabbitMqMsgParam);
    }
}
