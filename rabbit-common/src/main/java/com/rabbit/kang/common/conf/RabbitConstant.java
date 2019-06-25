package com.rabbit.kang.common.conf;

/**
 * @author kanghaijun
 * @create 2019/6/25
 * @describe
 */
public class RabbitConstant {

    //交换机
    public static final String MY_DIRECT_EXCHANGE = "my-direct-exchange";
    public static final String MY_TOPIC_EXCHANGE = "my-topic-exchange";
    public static final String MY_FANOUT_EXCHANGE = "my-fanout-exchange";
    //队列
    public static final String MY_FIRST_QUEUE = "my-first-queue";
    public static final String MY_SECOND_QUEUE = "my-second-queue";
    public static final String MY_THIRD_QUEUE = "my-third-queue";
    public static final String MY_FOURTH_QUEUE = "my-fourth-queue";
    public static final String MY_FIFTH_QUEUE = "my-fifth-queue";

    //路由键
    public static final String MY_DIRECT_ROUTING_KEY = "direct-routingKey";
    public static final String MY_TOPIC__ROUTING_KEY = "*.topic.*";

}
