package com.nancysahu8.kafka_project.controller;

import com.nancysahu8.kafka_project.kafka.JSONKafkaProducer;
import com.nancysahu8.kafka_project.modal.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/api/v1/kafkaMessages")
public class JSONMessageController {

    @Autowired
    private JSONKafkaProducer jsonKafkaProducer;

    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody User user) {
        jsonKafkaProducer.sendMessage(user);
        return ResponseEntity.ok("JSON Message published successfully to Kafka topic!");
    }
}
