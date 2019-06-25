package com.rabbit.kang.consume.conf.rabbit.consume;

import com.rabbit.kang.common.conf.RabbitConstant;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author kanghaijun
 * @create 2019/6/25
 * @describe
 */
@Component
public class FifthQueueConsume {

    @RabbitHandler
    @RabbitListener(queues = RabbitConstant.MY_FIFTH_QUEUE)
    public void process(String msg, Channel channel, Message message){
        System.out.println("fifth-queue : " + msg);
        System.out.println("CorrelationId: " + message.getMessageProperties().getCorrelationId());
        try {
            //消费完成
            channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);

            //消费失败，重回队列  消费失败该消息重回队列应有次数限制，否则造成队列阻塞
            //channel.basicNack(message.getMessageProperties().getDeliveryTag(),false,true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
