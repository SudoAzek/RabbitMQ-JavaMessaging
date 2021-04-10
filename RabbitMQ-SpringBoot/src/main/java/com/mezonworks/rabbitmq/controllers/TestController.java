package com.mezonworks.rabbitmq.controllers;

import com.mezonworks.rabbitmq.dto.Person;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class TestController {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @GetMapping("/test/{name}")
    public String testAPI(@PathVariable("name") String name) {
        Person p = new Person(1L, name);
        rabbitTemplate.convertAndSend("Mobile", p);
        rabbitTemplate.convertAndSend("Direct-Exchange", "mobile", p);
        rabbitTemplate.convertAndSend("Fanout-Exchange", "", p);
        rabbitTemplate.convertAndSend("Topic-Exchange", "tv.mobile.ac", p);
        return "Success";
    }
}