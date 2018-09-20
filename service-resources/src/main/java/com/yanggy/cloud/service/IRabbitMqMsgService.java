package com.yanggy.cloud.service;

import com.yanggy.cloud.entity.RabbitMqMessage;
import com.yanggy.cloud.param.RabbitMqMsgParam;
import com.yanggy.cloud.utils.ResponseEntityDto;

/**
 * @author derrick.yang
 * @Date 9/8/18 15:24
 */
public interface IRabbitMqMsgService {

    ResponseEntityDto<?> getRabbitMsg(RabbitMqMsgParam rabbitMqMsgParam);
    ResponseEntityDto<?> insertRabbitMqMsg(RabbitMqMessage rabbitMqMessage);
}
