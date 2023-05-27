package com.p.prod.producer.impl;

//import com.p.prod.Producer.Entity.Ingresso;
import com.p.prod.producer.Producer;
import com.p.prod.config.MessagingProperties;
import com.p.prod.entity.Ingresso;

import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import static lombok.AccessLevel.PRIVATE;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class IngressoProducerImpl implements Producer<Ingresso> {

    RabbitTemplate customRabbitTemplate;
    MessagingProperties messagingProperties;

    @Override
    public void produce(Ingresso ingresso) {

            customRabbitTemplate.convertAndSend(
                    messagingProperties.getExchangeName(), messagingProperties.getRoutingKey(), ingresso);
    }
}
