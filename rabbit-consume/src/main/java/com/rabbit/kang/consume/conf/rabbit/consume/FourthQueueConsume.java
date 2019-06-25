package com.rabbit.kang.consume.conf.rabbit.consume;

import com.rabbit.kang.common.conf.RabbitConstant;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author kanghaijun
 * @create 2019/6/25
 * @describe
 */
@Component
public class FourthQueueConsume {

    @RabbitHandler
    @RabbitListener(queues = RabbitConstant.MY_FOURTH_QUEUE)
    public void process(String msg){
        System.out.println("fourth-queue : " + msg);
    }

}
