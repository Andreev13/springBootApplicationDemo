package com.example.demo.resttemplate;

import com.example.demo.models.Information;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Component
@Slf4j
@AllArgsConstructor
public class MyRestTemplate {

    private final RestTemplate restTemplate;
//    private final ObjectMapper objectMapper;

    public String callGetRequestStab(){
        String url = "http://localhost:1314/call";
        log.info("Вызов заглушки " + url);
        HttpHeaders headers = new HttpHeaders();
        headers.add("First-Headers", "Stabs");
        HttpEntity<String> entity = new HttpEntity<>("Hello is server!", headers);
//        log.info(entity.getHeaders().toString());
//        log.info(entity.getBody().toString());
//        var response = restTemplate.postForObject(url, entity, Information.class);
        ResponseEntity<String> response2 = null;

        try {
            response2 = restTemplate.postForEntity(url, entity, String.class);
            log.info("headers:  " + response2.getHeaders().toString());
            log.info("Сообщение от заглушки: " + response2.getBody());
//            JsonNode body = objectMapper.readTree(response.getMassage());
//            JsonNode status = body.path("statusCode");
//            log.info("Возвращенный код от заглушки - " + response);

        } catch (Exception e) {
            log.error("Не удалось подключиться к заглушке " + e.getMessage());
        }
        return response2.getBody();
    }
}
