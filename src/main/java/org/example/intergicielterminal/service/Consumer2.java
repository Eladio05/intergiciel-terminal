package org.example.intergicielterminal.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer2 {

    private final Logger logger = LoggerFactory.getLogger(Consumer2.class);

    @KafkaListener(topics = "TOPIC_2", groupId = "my-group-id")
    public void listen(String message) {
        logger.info("Message recu par le consumer 2 : {}", message);

    }
}

