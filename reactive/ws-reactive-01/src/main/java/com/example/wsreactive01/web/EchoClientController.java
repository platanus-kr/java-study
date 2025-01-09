package com.example.wsreactive01.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class EchoClientController {
    @GetMapping
    public String show() {
        return "client";
    }
}
