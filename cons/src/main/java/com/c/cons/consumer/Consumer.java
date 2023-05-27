package com.c.cons.consumer;

public interface Consumer<T> {

    void consume(T message);
}
