package com.mezonworks.rabbitmq.consumers;

import com.mezonworks.rabbitmq.dto.Person;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQConsumer {

//    @RabbitListener(queues = "Mobile")
//    public void getMessage(Person person) {
//        System.out.println(person.getName());
//    }

}
