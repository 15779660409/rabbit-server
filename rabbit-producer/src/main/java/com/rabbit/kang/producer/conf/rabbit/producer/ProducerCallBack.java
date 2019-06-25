package com.rabbit.kang.producer.conf.rabbit.producer;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

/**
 * @author kanghaijun
 * @create 2019/6/25
 * @describe
 */
public class ProducerCallBack implements RabbitTemplate.ConfirmCallback, RabbitTemplate.ReturnCallback {

    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        String id = correlationData.getId();
        System.out.println("correlationData id " + id);
        if(ack){
            System.out.println("-----消息发送成功------");
        }else {
            System.out.println("-----消息发送失败------");
        }

    }

    @Override
    public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
        // 未能路由至相关队列
        System.out.println("未能路由至相关队列");
        String id = message.getMessageProperties().getMessageId();
        System.out.println(id);
        System.out.println("replyCode: " + replyCode + "，replyText: " + replyText + ",exchange: " + exchange + ",routingKey: " +routingKey);
    }
}
