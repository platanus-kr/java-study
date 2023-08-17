package com.tx.transaction1.txapply;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class TxLevelTest {

    @Autowired
    LevelTest service;

    @Test
    void orderTest() {
        service.write();
        service.read();
    }

    @TestConfiguration
    static class TxLevelTestConfig {
        @Bean
        LevelTest levelTest() {
            return new LevelTest();
        }
    }

    @Slf4j
    @Transactional(readOnly = true)
    static class LevelTest {
        @Transactional(readOnly = false)
        public void write() {
            log.info("Call write");
            printTxInfo();
        }

        public void read() {
            log.info("Call read");
            printTxInfo();
        }

        private void printTxInfo() {
            boolean isTxActive = TransactionSynchronizationManager.isActualTransactionActive();
            log.info("TX Active : {}", isTxActive);
            boolean isReadOnly = TransactionSynchronizationManager.isCurrentTransactionReadOnly();
            log.info("TX ReadOnly : {}", isReadOnly);
        }
    }
}
