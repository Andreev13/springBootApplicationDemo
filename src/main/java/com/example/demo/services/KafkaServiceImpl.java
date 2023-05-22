package com.example.demo.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
//@Profile("!test")

public class KafkaServiceImpl
//        implements KafkaService
        {

//    private KafkaTemplate<String,String> kafkaTemplate;
//
//    @Override
//    public void sendMessage(String topicName, String msg) {
//        kafkaTemplate.send(topicName, msg);
//        log.info("Сообщение отправлено в кафку!");
//    }
//
//    @Override
//    @KafkaListener(topics = "connect-test", groupId = "server.test.id")
//    public void listenMessage(String message) {
//        log.info("Message with kafka: " + message);
//    }

}
