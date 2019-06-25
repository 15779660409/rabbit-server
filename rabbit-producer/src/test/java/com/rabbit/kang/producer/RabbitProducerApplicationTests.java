package com.rabbit.kang.producer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitProducerApplicationTests {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void contextLoads() {
        //rabbitTemplate.convertAndSend("my-direct-exchange","direct-routingKey","kaka");
        //rabbitTemplate.convertAndSend("my-topic-exchange","student.topic.kang","kakakaka");
        rabbitTemplate.convertAndSend("my-fanout-exchange","fanout-routingKey","kaka");
    }

}
