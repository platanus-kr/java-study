package com.example.stringkafka;

import io.restassured.RestAssured;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class DtoMessageRestTest {

    public static final String LOCAL_ADDRESS = "http://localhost:3030";

    @Test
    void sendMessage() {
        String uid = UUID.randomUUID().toString();

        Map<String, String> body = new HashMap<>();
        body.put("uid", "1212-3232-4242");
        body.put("message", "메시지 " + uid);
        body.put("type", "TEXT");
        body.put("room_id", "1212-3232-4242");
        body.put("send_at", LocalDateTime.now().toString());

        RestAssured.given().log().all()
                .baseUri(LOCAL_ADDRESS)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(body)
                .when().post("/dto")
                .then().log().all()
                .extract();

    }
}
