package com.example.demo.connection;

import org.springframework.amqp.core.Binding;

import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.MessageListenerContainer;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    public Queue IngressoQueue() {
        return new Queue("ingressoA", false);
    }

    @Bean
    public TopicExchange IngressoExchange() {
        return new TopicExchange("ticket-exchange");
    }

    @Bean
    public Binding IngressoBinding(Queue ticketQueue, TopicExchange ticketExchange) {
        return BindingBuilder.bind(ticketQueue).to(ticketExchange).with("sell-ticket");
    }
}