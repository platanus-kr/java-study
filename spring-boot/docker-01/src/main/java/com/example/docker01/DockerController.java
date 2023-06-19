package com.example.docker01;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/")
public class DockerController {
    public static String uuid = UUID.randomUUID().toString();

    @GetMapping
    public String dockerPoint() {
        return "Hello " + uuid;
    }
}
