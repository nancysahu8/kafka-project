package com.nancysahu8.kafka_project.kafka;

import com.nancysahu8.kafka_project.modal.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JSONKafkaConsumer {
    private final static Logger LOGGER = LoggerFactory.getLogger(JSONKafkaConsumer.class);

    @KafkaListener(topics = "javajsontopic", groupId = "myGroup")
    public void consume(User user) {
        LOGGER.info("Received JSON message: {}", user.toString());
    }
}
