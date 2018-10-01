package com.yanggy.cloud.service;

import com.yang.cloud.entity.RabbitMqMessage;
import com.yang.cloud.param.RabbitMqMsgParam;
import com.yanggy.cloud.utils.ResponseEntityDto;

/**
 * @author derrick.yang
 * @Date 9/8/18 15:24
 */
public interface IRabbitMqMsgService {

    ResponseEntityDto<?> getRabbitMsg(RabbitMqMsgParam rabbitMqMsgParam);
    ResponseEntityDto<?> insertRabbitMqMsg(RabbitMqMessage rabbitMqMessage);
}
