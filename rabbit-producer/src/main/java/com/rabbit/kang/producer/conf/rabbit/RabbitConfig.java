package com.rabbit.kang.producer.conf.rabbit;

import com.rabbit.kang.producer.conf.rabbit.producer.ProducerCallBack;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @author kanghaijun
 * @create 2019/6/25
 * @describe
 */
@Configuration
public class RabbitConfig {

    @Autowired
    private ConnectionFactory connectionFactory;

    /**
     * rabbitmq的模板配置
     * @return
     */
    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE) //必须是prototype类型
    public RabbitTemplate rabbitTemplate() {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMandatory(true);
        template.setConfirmCallback(new ProducerCallBack());
        template.setReturnCallback(new ProducerCallBack());
        return template;
    }

}
