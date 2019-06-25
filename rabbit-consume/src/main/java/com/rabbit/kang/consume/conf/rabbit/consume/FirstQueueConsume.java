package com.rabbit.kang.consume.conf.rabbit.consume;

import com.rabbit.kang.common.conf.RabbitConstant;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author kanghaijun
 * @create 2019/6/24
 * @describe
 */
@Component
public class FirstQueueConsume {

    @RabbitHandler
    @RabbitListener(queues = RabbitConstant.MY_FIRST_QUEUE)
    public void process(String msg) {
        System.out.println("first-queue : " + msg);
    }

}
