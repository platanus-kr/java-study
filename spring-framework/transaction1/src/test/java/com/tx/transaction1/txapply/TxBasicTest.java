package com.tx.transaction1.txapply;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class TxBasicTest {

    @Autowired
    BasicService basicService;

    @TestConfiguration
    static class TxApplyBasicConfig {
        @Bean
        BasicService basicService() {
            return new BasicService();
        }
    }

    @Test
    void proxyCheck() {
        log.info("AOP Class : {}", basicService.getClass());
        Assertions.assertThat(AopUtils.isAopProxy(basicService)).isTrue();
    }

    @Test
    void txTest() {
        basicService.tx();
        basicService.nonTx();
    }

    @Slf4j
    static class BasicService {

        @Transactional
        public void tx() {
            log.info("Call TX");
            boolean isTxActive = TransactionSynchronizationManager.isActualTransactionActive();
            log.info("TX Active : {}", isTxActive);
        }

        public void nonTx() {
            log.info("Call NON-TX");
            boolean isTxActive = TransactionSynchronizationManager.isActualTransactionActive();
            log.info("TX Active : {}", isTxActive);
        }
    }

}
