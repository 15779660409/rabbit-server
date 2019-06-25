package com.rabbit.kang.consume;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRabbit
public class RabbitConsumeApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabbitConsumeApplication.class, args);
    }

}
