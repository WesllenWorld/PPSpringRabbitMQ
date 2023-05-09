package com.example.demo.connection;

import org.apache.logging.log4j.message.SimpleMessage;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.cache.annotation.Caching;

public class AMQPCloud {
    
    public static void execute() {
        
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory("jackal.rmq.cloudamqp.com");
        connectionFactory.setUsername("tirygekb");
        connectionFactory.setPassword("23tHYgpvhomyo71JwcS4eWmF7VEryqQg");
        connectionFactory.setVirtualHost("tirygekb");
        
        connectionFactory.setRequestedHeartBeat(30);
        connectionFactory.setConnectionTimeout(30000);

        RabbitAdmin admin = new RabbitAdmin(connectionFactory);
        Queue queue = new Queue("Basicona");
        admin.declareQueue(queue);
        TopicExchange exchange = new TopicExchange("Basicona");

        admin.declareExchange(exchange);

        admin.declareBinding(BindingBuilder.bind(queue).to(exchange).with("foo.*"));

        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory);
        Object listener = new Object(){
            public void handleMessage(String foo){
                System.out.println("Messager listener handling:");
                System.out.println(foo);
            }
        };

        MessageListenerAdapter adapter = new MessageListenerAdapter(listener);
        container.setMessageListener(adapter);
        container.setQueueNames("Basicona");
        container.start();

        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.convertAndSend("Basicona", "foo.bar", "Hello CloudAMQP!");
        try {
            Thread.sleep(1000);
            
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
        container.stop();
        
    }
}
