package com.demo.rocketmq;

import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestProducer {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    public void send(String topic, String message) {

        rocketMQTemplate.convertAndSend(topic, message);

    }
}
