package com.nancysahu8.kafka_project.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {
    //creating new bean
    @Bean
    public NewTopic javaTopic() {
        return TopicBuilder.name("javatopic").partitions(4).build();
    }
}
