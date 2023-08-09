package com.example.scheduler01;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class LogAcceptanceTest {
    private final WebClient webClient = WebClient.create("http://localhost:8080");

    @Test
    void log_input_test() {

        Map<String, Object> data = new HashMap<>();
        data.put("created", LocalDateTime.now());
        data.put("log", UUID.randomUUID());

        // TODO 완성하세요.

//        Mono<Object> objectMono = webClient.post()
//                .uri("/log")
//                .contentType(MediaType.APPLICATION_JSON)
//                .body(BodyInserters.fromValue(data))
//                .exchangeToMono(response -> response.statusCode());
////                .retrieve();
//
//
//        Mono<String> responseMono = retrieve
//                .bodyToMono(String.class).log();
//
//        StepVerifier.create(responseMono)
//                .expectNextMatches(response -> !response.isEmpty())
//                .verifyComplete();
    }
}
