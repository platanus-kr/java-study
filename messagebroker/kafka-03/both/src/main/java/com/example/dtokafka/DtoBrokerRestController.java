package com.example.dtokafka;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dto")
@RequiredArgsConstructor
public class DtoBrokerRestController {

    private final DtoProducer dtoProducer;

    @PostMapping
    public ResponseEntity<Void> sendMessage(@RequestBody MessageDto message) {
        dtoProducer.sendMessage(message);
        return ResponseEntity.ok().build();
    }

}
