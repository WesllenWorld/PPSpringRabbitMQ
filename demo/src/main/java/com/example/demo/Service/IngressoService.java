package com.example.demo.Service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Ingresso;

@Service
public class IngressoService {
    
    @RabbitListener(queues = "ingressoA")
    public void receiveTicket(Ingresso ingresso) {
        // Process the ticket and save it to the database or perform other necessary actions
        System.out.println("Received ticket: " + ingresso.toString());
    }

}
