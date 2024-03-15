package org.example.intergicielterminal.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producter2 {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private static final String TOPIC = "TOPIC_2";

    @Autowired
    public Producter2(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String message, String topicName) {
        kafkaTemplate.send(topicName, message);
        System.out.println("Produced message: " + message + " to topic: " + topicName);
    }
}
