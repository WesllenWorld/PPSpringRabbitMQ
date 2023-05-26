package com.p.prod.Producer.impl;

import com.p.prod.Config.MessagingProperties;
//import com.p.prod.Producer.Entity.Ingresso;
import com.p.prod.Producer.Producer;
import com.p.prod.Entity.Ingresso;

import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import static lombok.AccessLevel.PRIVATE;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class OrderProducerImpl implements Producer<Ingresso> {

    RabbitTemplate customRabbitTemplate;
    MessagingProperties messagingProperties;

    @Override
    public void produce(Ingresso ingresso) {

            customRabbitTemplate.convertAndSend(
                    messagingProperties.getExchangeName(), messagingProperties.getRoutingKey(), ingresso);
    }
}
