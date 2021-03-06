package com.yang.cloud.mapper;

import com.yang.cloud.entity.RabbitMqMessage;
import com.yang.cloud.param.RabbitMqMsgParam;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author derrick.yang
 * @Date 8/28/18 17:52
 */
@Component
@Mapper
public interface RabbitMqMessageMapper {
    int addMessage(RabbitMqMessage rabbitMqMessage);

    int updateMsgStatus(RabbitMqMsgParam rabbitMqMessage);

    List<RabbitMqMessage> getMessages(RabbitMqMsgParam rabbitMqMessage);
}
