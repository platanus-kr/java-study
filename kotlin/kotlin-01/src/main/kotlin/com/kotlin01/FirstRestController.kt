package com.kotlin01

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class FirstRestController {

    @GetMapping("/asdf")
    fun firstRestApi(): String {
        return "200";
    }
}