package com.example.central.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class FrontController {
    @GetMapping("/front")
    public String front() {
        return "asdf";
    }
}
