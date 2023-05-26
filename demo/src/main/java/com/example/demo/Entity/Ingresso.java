package com.example.demo.Entity;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Ingresso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    
    private String nomeEvento;
    private String local;
    private BigDecimal preco;
    private int quantidade;

    public Ingresso() {
    }

    public Ingresso(String id, String nomeEvento, String local, BigDecimal preco, int quantidade) {
        this.id = id;
        this.nomeEvento = nomeEvento;
        this.local = local;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public String getId() {
        return this.id;
    }

    public String getNomeEvento() {
        return this.nomeEvento;
    }

    public String getLocal() {
        return this.local;
    }

    public BigDecimal getPreco() {
        return this.preco;
    }

    public int getQuantidade() {
        return this.quantidade;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNomeEvento(String nomeEvento) {
        this.nomeEvento = nomeEvento;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String toString(){
        return "Ingresso: " + this.id + " " + this.nomeEvento + " " + this.local + " " + this.preco + " " + this.quantidade;
    }
}
