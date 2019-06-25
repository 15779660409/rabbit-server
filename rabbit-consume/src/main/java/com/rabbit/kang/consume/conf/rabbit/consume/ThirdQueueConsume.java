package com.rabbit.kang.consume.conf.rabbit.consume;

import com.rabbit.kang.common.conf.RabbitConstant;
import com.rabbit.kang.common.entity.User;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author kanghaijun
 * @create 2019/6/25
 * @describe
 */
@Component
public class ThirdQueueConsume {

    @RabbitHandler
    @RabbitListener(queues = RabbitConstant.MY_THIRD_QUEUE)
    public void process(User user){
        System.out.println("third-queue : " + user);
    }

}
