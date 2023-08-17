package com.example.webapptest3.aop;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BService {
    private static boolean isRunning = false;

    public void execute() {
        isRunning = true;
        log.info("aService running");
        try{
            Thread.sleep(3000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        isRunning = false;
        log.info("aService done");
    }
}
