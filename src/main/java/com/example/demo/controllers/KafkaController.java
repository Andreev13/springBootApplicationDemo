package com.example.demo.controllers;

import com.example.demo.services.KafkaService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Slf4j
public class KafkaController {

//    private KafkaService kafkaService;
//
//    @PostMapping("kafka/")
//    public String sendMessageKafka(@RequestBody String msg){
//        kafkaService.sendMessage("connect-test", msg);
//        log.info("Сообщение в кафку с содержимым " + msg + ", отправлено!");
//        return "Сообщение в кафку с содержимым " + msg + ", отправлено!";
//    }

}
