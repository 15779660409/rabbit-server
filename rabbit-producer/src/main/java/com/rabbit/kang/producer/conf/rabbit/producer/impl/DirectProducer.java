package com.rabbit.kang.producer.conf.rabbit.producer.impl;

import com.rabbit.kang.common.conf.RabbitConstant;
import com.rabbit.kang.producer.conf.rabbit.producer.IProducer;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author kanghaijun
 * @create 2019/6/25
 * @describe
 */
@Service("directProducer")
public class DirectProducer implements IProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void send(Object msg, String messageId, Integer delayTime) {
        CorrelationData correlationData = new CorrelationData();
        // 	 全局唯一 消息ID
        correlationData.setId(messageId);
        rabbitTemplate.convertAndSend(
                RabbitConstant.MY_DIRECT_EXCHANGE,
                RabbitConstant.MY_DIRECT_ROUTING_KEY,
                msg,
                new MessagePostProcessor() {
                    @Override
                    public Message postProcessMessage(Message message) throws AmqpException {
                        message.getMessageProperties().setCorrelationId(messageId);
                        if(delayTime != null){
                            message.getMessageProperties().setExpiration(delayTime + "");
                        }
                        return message;
                    }
                },
                correlationData
        );
    }
}
