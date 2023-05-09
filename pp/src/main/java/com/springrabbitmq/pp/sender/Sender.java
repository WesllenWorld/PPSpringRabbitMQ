package com.springrabbitmq.pp.sender;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Sender {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    private Queue queue;
    
    @Autowired
    public Sender(RabbitTemplate rabbitTemplate, Queue queue) {
        this.rabbitTemplate = rabbitTemplate;
        this.queue = queue;
    }
    
    public void send(String message) {
        rabbitTemplate.convertAndSend(queue.getName(), message);
        System.out.println("Mensagem enviada: " + message);
    }
}