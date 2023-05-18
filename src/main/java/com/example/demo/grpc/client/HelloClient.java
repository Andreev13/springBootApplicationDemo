package com.example.demo.grpc.client;

import com.example.demo.HelloRequest;
import com.example.demo.HelloResponse;
import com.example.demo.HelloServiceGrpc;
import com.example.demo.ServiceHello;
import com.google.protobuf.Descriptors;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

import java.util.Map;

@Slf4j
@Service
public class HelloClient {

    @GrpcClient("call-sever")
    private HelloServiceGrpc.HelloServiceBlockingStub synchronousClient;

    public String getHello() {
        HelloRequest helloRequest = HelloRequest.newBuilder()
                .setFirstName("Igor")
                .setLastName("Andreev")
                .build();
        HelloResponse helloResponse = synchronousClient.hello(helloRequest);
        log.info(helloResponse.getGreeting());
        return helloResponse.getGreeting();
    }

}
