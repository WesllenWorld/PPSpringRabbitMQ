package com.p.prod.config;

import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static lombok.AccessLevel.PRIVATE;

@Configuration
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class MessagingConfig {

    MessagingProperties messagingProperties;
    static final int REQUESTED_HEARTBEAT = 30;
    static final int CONNECTION_TIMEOUT = 30_000;

    @Bean
    public Queue queue() {

        return new Queue(messagingProperties.getQueueName());
    }

    @Bean
    public TopicExchange exchange() {

        return new TopicExchange(messagingProperties.getExchangeName());
    }

    @Bean
    public Binding binding(Queue queue, TopicExchange exchange) {

        return BindingBuilder
                .bind(queue)
                .to(exchange)
                .with(messagingProperties.getRoutingKey());
    }

    @Bean
    public MessageConverter converter() {

        return new Jackson2JsonMessageConverter();
    }

    @Bean
    CachingConnectionFactory cachingConnectionFactory() {

        CachingConnectionFactory cachingConnectionFactory =
                new CachingConnectionFactory(messagingProperties.getHostname());
        cachingConnectionFactory.setUsername(messagingProperties.getUsername());
        cachingConnectionFactory.setPassword(messagingProperties.getPassword());
        cachingConnectionFactory.setVirtualHost(messagingProperties.getVirtualHost());
        cachingConnectionFactory.setRequestedHeartBeat(REQUESTED_HEARTBEAT);
        cachingConnectionFactory.setConnectionTimeout(CONNECTION_TIMEOUT);

        return cachingConnectionFactory;
    }

    @Bean
    public AmqpTemplate customRabbitTemplate(CachingConnectionFactory cachingConnectionFactory) {

        final RabbitTemplate rabbitTemplate = new RabbitTemplate(cachingConnectionFactory);
        rabbitTemplate.setMessageConverter(converter());

        return rabbitTemplate;
    }
}
