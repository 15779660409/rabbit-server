package com.rabbit.kang.consume.conf.rabbit;

import com.rabbit.kang.common.conf.RabbitConstant;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author kanghaijun
 * @create 2019/6/24
 * @describe
 */
@Component
@Configuration
public class RabbitMQConfig {

    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange(RabbitConstant.MY_DIRECT_EXCHANGE);
    }

    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange(RabbitConstant.MY_TOPIC_EXCHANGE);
    }

    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange(RabbitConstant.MY_FANOUT_EXCHANGE);
    }

    @Bean
    public Queue firstQueue(){
        return new Queue(RabbitConstant.MY_FIRST_QUEUE);
    }

    @Bean
    public Queue secondQueue(){
        return new Queue(RabbitConstant.MY_SECOND_QUEUE);
    }

    @Bean
    public Queue thirdQueue(){
        return new Queue(RabbitConstant.MY_THIRD_QUEUE);
    }

    @Bean
    public Queue fourthQueue(){
        return new Queue(RabbitConstant.MY_FOURTH_QUEUE);
    }

    @Bean
    public Queue fifthQueue(){
        return new Queue(RabbitConstant.MY_FIFTH_QUEUE);
    }

    @Bean
    public Binding bindingFirstQueue(Queue firstQueue,DirectExchange directExchange){
        return BindingBuilder.bind(firstQueue).to(directExchange).with(RabbitConstant.MY_DIRECT_ROUTING_KEY);
    }

    @Bean
    public Binding bindingSecondQueue(Queue secondQueue,TopicExchange topicExchange){
        return BindingBuilder.bind(secondQueue).to(topicExchange).with(RabbitConstant.MY_TOPIC__ROUTING_KEY);
    }

    @Bean
    public Binding bindingThirdQueue(Queue thirdQueue,TopicExchange topicExchange){
        return BindingBuilder.bind(thirdQueue).to(topicExchange).with(RabbitConstant.MY_TOPIC__ROUTING_KEY);
    }

    @Bean
    public Binding bindingFourthQueue(Queue fourthQueue,FanoutExchange fanoutExchange){
        return BindingBuilder.bind(fourthQueue).to(fanoutExchange);
    }

    @Bean
    public Binding bindingFifthQueue(Queue fifthQueue,FanoutExchange fanoutExchange){
        return BindingBuilder.bind(fifthQueue).to(fanoutExchange);
    }
}
