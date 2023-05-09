package com.springrabbitmq.pp;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.springrabbitmq.pp.sender.Receiver;
import com.springrabbitmq.pp.sender.Sender;

@EnableRabbit
@SpringBootApplication
public class Application {

	public static void main(String[] args) throws InterruptedException{
		//ConfigurableApplicationContext context = 
        SpringApplication.run(Application.class, args);
		//Sender sender = context.getBean(Sender.class);
        //Receiver receiver = context.getBean(Receiver.class);

       // sender.send("Hello, RabbitMQ!");

       // Thread.sleep(1000);

       // context.close();


	}

}
