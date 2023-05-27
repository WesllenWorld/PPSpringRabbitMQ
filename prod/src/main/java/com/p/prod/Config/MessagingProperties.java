package com.p.prod.config;

import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import static lombok.AccessLevel.PRIVATE;

@Component
@Data
@FieldDefaults(level = PRIVATE)
@ConfigurationProperties(prefix = "rabbitmq.config")
public class MessagingProperties {

    String hostname;
    String password;
    String username;
    String virtualHost;
    String queueName;
    String exchangeName;
    String routingKey;
}
