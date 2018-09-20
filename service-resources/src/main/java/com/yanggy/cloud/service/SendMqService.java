package com.yanggy.cloud.service;

/**
 * @author derrick.yang
 * @Date 8/28/18 18:00
 */
public interface SendMqService {

    void sendMessage(String exchange, String routingkey, Object message);
}
