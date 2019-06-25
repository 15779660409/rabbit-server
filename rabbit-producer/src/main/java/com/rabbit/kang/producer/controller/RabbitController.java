package com.rabbit.kang.producer.controller;

import com.rabbit.kang.common.entity.User;
import com.rabbit.kang.producer.conf.rabbit.producer.IProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kanghaijun
 * @create 2019/6/25
 * @describe
 */
@RestController
@RequestMapping("rabbit")
public class RabbitController {

    private static Integer id = 0;


    @Autowired
    private IProducer directProducer;

    @Autowired
    private IProducer topicProducer;

    @Autowired
    private IProducer fanoutProducer;

    @RequestMapping("direct")
    public String direct(String msg){
        id++;
        directProducer.send(msg,id.toString(),null);
        return "success";
    }

    @RequestMapping("topic")
    public String topic(User user){
        id++;
        topicProducer.send(user,id.toString(),null);
        return "success";
    }

    @RequestMapping("fanout")
    public String fanout(String msg){
        id++;
        fanoutProducer.send(msg,id.toString(),null);
        return "success";
    }

}
