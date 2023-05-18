package com.example.demo.grpc.client;

import com.google.protobuf.Descriptors;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@Slf4j
@AllArgsConstructor
public class HelloController {

    private HelloClient helloClient;

    @GetMapping("/grpc/hello/")
    public String getHello(){
        log.info("Была вызвана служба grpc\n");
        return helloClient.getHello();
    }
}
