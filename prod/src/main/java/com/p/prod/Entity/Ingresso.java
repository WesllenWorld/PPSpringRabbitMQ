package com.p.prod.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor
@AllArgsConstructor
@Data
@FieldDefaults(level = PRIVATE)
public class Ingresso {

    private String id;
    private String nomeEvento;
    private double preco;
    private int quantidade;

    public String toString(){
        return "Ingresso: " + this.id + " " + this.nomeEvento + " " + this.preco + " " + this.quantidade;
    }
}
