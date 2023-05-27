package com.p.prod.producer;

public interface Producer<T> {

    void produce(T message);
}
