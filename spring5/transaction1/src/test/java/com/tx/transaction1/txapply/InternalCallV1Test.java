package com.tx.transaction1.txapply;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import lombok.extern.slf4j.Slf4j;

/**
 * Spring AOP의 문제가 되는 상황 - 트랜잭션의 전파와 관련된 이슈
 * 해결은 -> InternalCallV2Test.
 */
@Slf4j
@SpringBootTest
public class InternalCallV1Test {

    @Autowired
    CallService callService;

    @TestConfiguration
    static class InternalCallV1TestConfig {
        @Bean
        CallService callService() {
            return new CallService();
        }
    }

    @Test
    void printProxy() {
        log.info("callService Class : {}", callService);
    }

    /**
     * 2022-08-18 11:27:53.395  INFO 15428 --- [    Test worker] c.t.t.txapply.InternalCallV1Test         : Call Internal
     * 2022-08-18 11:27:53.395  INFO 15428 --- [    Test worker] c.t.t.txapply.InternalCallV1Test         : TX Active : true
     * 2022-08-18 11:27:53.395  INFO 15428 --- [    Test worker] c.t.t.txapply.InternalCallV1Test         : TX ReadOnly : true
     */
    @Test
    void internalCall() {
        callService.internal();
    }

    /**
     * 2022-08-18 11:27:20.331  INFO 508044 --- [    Test worker] c.t.t.txapply.InternalCallV1Test         : Call External
     * 2022-08-18 11:27:20.331  INFO 508044 --- [    Test worker] c.t.t.txapply.InternalCallV1Test         : TX Active : false
     * 2022-08-18 11:27:20.331  INFO 508044 --- [    Test worker] c.t.t.txapply.InternalCallV1Test         : TX ReadOnly : false
     * 2022-08-18 11:27:20.331  INFO 508044 --- [    Test worker] c.t.t.txapply.InternalCallV1Test         : Call Internal
     * 2022-08-18 11:27:20.331  INFO 508044 --- [    Test worker] c.t.t.txapply.InternalCallV1Test         : TX Active : false
     * 2022-08-18 11:27:20.331  INFO 508044 --- [    Test worker] c.t.t.txapply.InternalCallV1Test         : TX ReadOnly : false
     */
    @Test
    void externalCall() {
        callService.external();
    }

    static class CallService {
        public void external() {
            log.info("Call External");
            printTxInfo();
            // @Transactional 가 적용된 메소드를 내부 호출 시도
            internal();
        }

        @Transactional
        public void internal() {
            log.info("Call Internal");
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
