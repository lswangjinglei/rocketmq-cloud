package com.longshine;

import com.longshine.rocketmq.TestProducer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProducerTest {

    @Autowired
    private TestProducer producer;

    @Test
    void testProducer() {
        producer.send("TestTopic", "TestMessage");
    }
}
