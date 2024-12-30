package com.demo.controller;

import com.demo.rocketmq.TestProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestProducerController {

    @Autowired
    private TestProducer testProducer;

    @PostMapping("/producer")
    public String producer(@RequestBody String message) {
        testProducer.send("order", message);
        return "SUCCESS!!";
    }
}
