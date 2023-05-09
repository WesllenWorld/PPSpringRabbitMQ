package com.springrabbitmq.pp.sender;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver implements MessageListener {

    @Override
    public void onMessage(Message message) {
        String receivedMessage = new String(message.getBody());
        System.out.println("Received message: " + receivedMessage);
    }
}