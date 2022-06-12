package com.example.log4jtest;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class TestController {

    Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping("/logging")
    public String logging(){
        String datetime = LocalDateTime.now().toString();
        logger.info(">> " + datetime);
        int idx = 10;
        while(idx > 0){
            Thread t = new TestThread(idx);
            t.start();
            idx--;
        }
        return "200";
    }
}
