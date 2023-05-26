package com.p.prod.Controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.p.prod.Entity.*;;

@RestController
public class IngressoController {
    
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostMapping("/sell")
    public String sellTicket(@RequestBody Ingresso ticket) {
        rabbitTemplate.convertAndSend("ticket-exchange", "sell-ticket", ticket);
        return "Ticket sent to the queue for processing.";
    }
}