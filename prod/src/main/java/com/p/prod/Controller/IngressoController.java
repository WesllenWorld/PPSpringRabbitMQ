package com.p.prod.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import static lombok.AccessLevel.PRIVATE;

import com.p.prod.entity.*;
import com.p.prod.producer.Producer;

import java.util.UUID;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/ingressos")
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class IngressoController {
    
    Producer<Ingresso> ingressoProducer;

    @PostMapping(path = "", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(CREATED)
    public void comprarIngresso(@RequestBody Ingresso ingresso) {

        ingresso.setId(UUID.randomUUID().toString());
        ingressoProducer.produce(ingresso);
        System.out.println("#### Mensagem enviada para a fila : " + ingresso.toString());
        

    }
}