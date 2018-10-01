package com.yanggy.cloud.service.impl;

import com.yang.cloud.entity.RabbitMqMessage;
import com.yang.cloud.param.RabbitMqMsgParam;
import com.yanggy.cloud.config.enums.ErrorCode;
import com.yanggy.cloud.mapper.RabbitMqMessageMapper;
import com.yanggy.cloud.service.IRabbitMqMsgService;
import com.yanggy.cloud.utils.ResponseEntityBuilder;
import com.yanggy.cloud.utils.ResponseEntityDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author derrick.yang
 * @Date 9/8/18 15:24
 */

@Service
public class RabbitMqMsgServiceImpl implements IRabbitMqMsgService {
    private final static Logger logger = LoggerFactory.getLogger(RabbitMqMsgServiceImpl.class);

    @Autowired
    private RabbitMqMessageMapper rabbitMqMessageMapper;

    @Override
    public ResponseEntityDto<?> getRabbitMsg(RabbitMqMsgParam rabbitMqMsgParam) {
        ResponseEntityDto<?> res;

        try {

            int offset = rabbitMqMsgParam.getPage() * rabbitMqMsgParam.getPageSize() - rabbitMqMsgParam.getPageSize();
            rabbitMqMsgParam.setOffset(offset);
            res = ResponseEntityBuilder.buildNormalResponseEntity(rabbitMqMessageMapper.getMessages(rabbitMqMsgParam));
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("查询消息列表错误", e.getMessage());
            res = ResponseEntityBuilder.buildErrorResponseEntity(ErrorCode.UNKONWN_ERROR);
        }
        return res;
    }

    @Override
    public ResponseEntityDto<?> insertRabbitMqMsg(RabbitMqMessage rabbitMqMessage) {
        ResponseEntityDto<?> res;

        try {
            rabbitMqMessageMapper.addMessage(rabbitMqMessage);
            res = ResponseEntityBuilder.buildNormalResponseEntity();
        } catch (Exception e) {
            logger.error("新增rabbitMq消息错误", e.getMessage());
            res = ResponseEntityBuilder.buildErrorResponseEntity(ErrorCode.UNKONWN_ERROR);
        }
        return res;
    }
}
