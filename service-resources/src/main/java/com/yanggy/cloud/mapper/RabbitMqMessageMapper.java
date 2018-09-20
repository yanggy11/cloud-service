package com.yanggy.cloud.mapper;

import com.yanggy.cloud.entity.RabbitMqMessage;
import com.yanggy.cloud.param.RabbitMqMsgParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author derrick.yang
 * @Date 8/28/18 17:52
 */

@Mapper
public interface RabbitMqMessageMapper {
    int addMessage(RabbitMqMessage rabbitMqMessage);

    int updateMsgStatus(RabbitMqMsgParam rabbitMqMessage);

    List<RabbitMqMessage> getMessages(RabbitMqMsgParam rabbitMqMessage);
}
