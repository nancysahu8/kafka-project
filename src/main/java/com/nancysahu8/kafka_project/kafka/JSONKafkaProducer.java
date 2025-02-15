package com.nancysahu8.kafka_project.kafka;

import com.nancysahu8.kafka_project.modal.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class JSONKafkaProducer {
    private static final Logger LOGGER = LoggerFactory.getLogger(JSONKafkaProducer.class);

    private KafkaTemplate<String, User> kafkaTemplate;

    public JSONKafkaProducer(KafkaTemplate<String, User> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(User user) {
        LOGGER.info("Sending message: {}", user);
        Message<User> msg = MessageBuilder.withPayload(user)
                .setHeader(KafkaHeaders.TOPIC, "javajsontopic")
                .build();
        kafkaTemplate.send(msg);
    }
 }
