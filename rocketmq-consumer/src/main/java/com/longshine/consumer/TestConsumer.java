package com.longshine.consumer;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

@Component
@RocketMQMessageListener(nameServer = "${rocketmq.name-server}", topic = "TestTopic", consumerGroup = "TestGroup")
public class TestConsumer implements RocketMQListener<String> {
    @Override
    public void onMessage(String message) {
        System.out.println("接收消息：" + message);
    }
}
