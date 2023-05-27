package com.c.cons.consumer.impl;

import com.c.cons.consumer.Consumer;
import com.c.cons.entity.*;

import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import static lombok.AccessLevel.PRIVATE;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class IngressoConsumerImpl implements Consumer<Ingresso> {

    private static final String QUEUE_NAME = "filaPedidos";

    @Override
    @RabbitListener(queues = QUEUE_NAME)
    public void consume(Ingresso ingresso) {

        System.out.printf("#### Message received from queue : %s\n", ingresso.toString());
    }
}
