package com.example.both;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
@RequiredArgsConstructor
public class MessageRestController {

    private final Producer kafkaProducer;

    @GetMapping
    public ResponseEntity<Void> sendMessage(@RequestParam("text") String message) {
        if (message == null || message.length() < 1) {
            return ResponseEntity.badRequest().build();
        }
        kafkaProducer.sendMessage(message);
        return ResponseEntity.ok().build();
    }
}
