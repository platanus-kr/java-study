package com.example.stringkafka;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class StringMessageRestTest {

    public static final String LOCAL_ADDRESS = "http://localhost:3030";

    @Test
    void sendMessage() {
        RestAssured.given().baseUri(LOCAL_ADDRESS).param("text", "전송")
                .when().get("/string")
                .then().extract();

    }
}
