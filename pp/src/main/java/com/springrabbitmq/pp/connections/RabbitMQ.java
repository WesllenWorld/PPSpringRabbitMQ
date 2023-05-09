package com.springrabbitmq.pp.connections;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
@EnableRabbit
public class RabbitMQ {
    //@Autowired
    //private CachingConnectionFactory cachingConnectionFactory;

    @Bean
    public CachingConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory("jackal.rmq.cloudamqp.com");
        connectionFactory.setUsername("tirygekb:tirygekb");
        connectionFactory.setPassword("23tHYgpvhomyo71JwcS4eWmF7VEryqQg");
        connectionFactory.setVirtualHost("tirygekb");
        return connectionFactory;
    }

    @Bean
    public RabbitTemplate rabbitTemplate() {
        //ConnectionFactory factory = connectionFactory();
        //RabbitTemplate rTemplate = new RabbitTemplate(connectionFactory());
        return new RabbitTemplate(connectionFactory());
    }
}
