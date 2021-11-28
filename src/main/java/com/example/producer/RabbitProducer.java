package com.example.producer;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    public Queue queue;

    public void send(MyUser user) {
        rabbitTemplate.convertAndSend(this.queue.getName(), user);
    }

}
