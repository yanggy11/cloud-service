package com.yanggy.cloud.service.impl;

import com.yanggy.cloud.service.SendMqService;
import org.springframework.stereotype.Component;

/**
 * @author derrick.yang
 * @Date 8/28/18 18:00
 */

@Component
public class SendMqServiceImpl implements SendMqService {

//    @Autowired
//    private AmqpTemplate amqpTemplate;
//
//    @Autowired
//    private RabbitMqMessageMapper rabbitMqMessageMapper;
//
//    @Override
//    public void sendMessage(String exchange, String routingkey, Object message) {
//        RabbitMqMessage rabbitMqMessage = new RabbitMqMessage();
//
//        rabbitMqMessage.setMessageId(UUID.randomUUID().toString().replace("-",""));
//        rabbitMqMessage.setExchange(exchange);
//        rabbitMqMessage.setRoutingKey(routingkey);
//        rabbitMqMessage.setMessage(message.toString());
//        rabbitMqMessage.setType(0);
//
//        rabbitMqMessageMapper.addMessage(rabbitMqMessage);
//
//        amqpTemplate.convertAndSend(exchange, routingkey, message);
//    }
}
