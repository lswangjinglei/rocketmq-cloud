package com.demo.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;

@Slf4j
@Component
@RocketMQMessageListener(nameServer = "${rocketmq.name-server}", topic = "testOrder", consumerGroup = "test-rocket-mq-cloud-consumer")
public class TestConsumer implements RocketMQListener<MessageExt> {

    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public void onMessage(MessageExt message) {
        log.info("[ {} ] 接收到消息：{} ", simpleDateFormat.format(System.currentTimeMillis()), new String(message.getBody(), StandardCharsets.UTF_8));
    }
}
