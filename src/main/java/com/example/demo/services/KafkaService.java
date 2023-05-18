package com.example.demo.services;

public interface KafkaService {
    void sendMessage(String topicName,String msg);
    void listenMessage(String message);
}
