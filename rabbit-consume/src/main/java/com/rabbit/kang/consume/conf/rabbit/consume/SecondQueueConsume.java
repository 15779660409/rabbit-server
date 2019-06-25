package com.rabbit.kang.consume.conf.rabbit.consume;

import com.rabbit.kang.common.conf.RabbitConstant;
import com.rabbit.kang.common.entity.User;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author kanghaijun
 * @create 2019/6/25
 * @describe
 */
@Component
public class SecondQueueConsume {

    @RabbitHandler
    @RabbitListener(queues = RabbitConstant.MY_SECOND_QUEUE)
    public void process(User user){
        System.out.println("second-queue : " + user);
    }
}
