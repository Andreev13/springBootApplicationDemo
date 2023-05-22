package com.example.demo.kafka.config;

import com.example.demo.kafka.dto.StarshipDto;
import com.fasterxml.jackson.databind.JsonSerializer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.LongSerializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.converter.StringJsonMessageConverter;

import java.util.HashMap;
import java.util.Map;

//@Configuration
//@Profile("!test")
public class KafkaProducerConfig {
//
//
//    private final String kafkaServer = "tvldq-ekp000022.delta.sbrf.ru:9092," +
//            "tvldq-ekp000023.delta.sbrf.ru:9092," +
//            "tvldq-ekp000024.delta.sbrf.ru:9092";
//
//    @Value(value = "${spring.kafka.bootstrap-servers}")
//    private String bootstrapAddress;
//
//
//    private final String kafkaProducerId = "server.test.id";
//
//    @Bean
//    public Map<String, Object> producerConfigs() {
//        Map<String, Object> props = new HashMap<>();
//        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
//        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
//        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
//        props.put(ProducerConfig.CLIENT_ID_CONFIG, kafkaProducerId);
//        return props;
//    }
//
//    @Bean
//    public ProducerFactory<String, String> producerStarshipFactory(){
//        return new DefaultKafkaProducerFactory<>(producerConfigs());
//    }
//
//    @Bean
//    public KafkaTemplate<String, String> kafkaTemplate(){
//        return new KafkaTemplate<>(producerStarshipFactory());
//    }
//
//
//


}