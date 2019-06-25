package com.rabbit.kang.producer.conf.rabbit.producer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kanghaijun
 * @create 2019/6/25
 * @describe
 */
public interface IProducer {

    /**
     *
     * @param msg 发送的消息体
     * @param messageId 该条消息作为mq中的唯一id
     * @param delayTime 该条消息的过期时间
     */
    public void send(Object msg,String messageId,Integer delayTime);

}
