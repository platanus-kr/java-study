package com.example.log4jtest;

import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.core.config.plugins.util.ResolverUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.TreeMap;

public class TestThread extends Thread{
    private int seq;
    Logger logger = LoggerFactory.getLogger(getClass());

    public TestThread(int seq){
        this.seq = seq;
    }

    public void run(){
        logger.info(this.seq + "logging");
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            logger.error(this.seq + " thread error");
        }
    }
}
