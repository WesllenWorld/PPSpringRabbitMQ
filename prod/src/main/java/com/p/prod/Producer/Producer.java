package com.p.prod.Producer;

public interface Producer<T> {

    void produce(T message);
}
