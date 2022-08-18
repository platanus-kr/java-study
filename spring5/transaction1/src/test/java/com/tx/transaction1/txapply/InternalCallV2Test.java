package com.tx.transaction1.txapply;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * InternalCallV1Test의 트랜잭션 전파를 해결하는 테스트
 * 이슈 상황은 -> InternalCallV1Test
 */
@Slf4j
@SpringBootTest
public class InternalCallV2Test {

    @Autowired
    CallService callService;

    @TestConfiguration
    static class InternalCallV1TestConfig {
        @Bean
        CallService callService() {
            return new CallService(internalService());
        }

        @Bean
        InternalService internalService() {
            return new InternalService();
        }
    }

    @Test
    void printProxy() {
        log.info("callService Class : {}", callService);
    }

    /**
     * 2022-08-18 13:32:21.439  INFO 480188 --- [    Test worker] c.t.t.t.InternalCallV2Test$CallService   : Call External
     * 2022-08-18 13:32:21.440  INFO 480188 --- [    Test worker] c.t.t.t.InternalCallV2Test$CallService   : TX Active : false
     * 2022-08-18 13:32:21.522 TRACE 480188 --- [    Test worker] o.s.t.i.TransactionInterceptor           : Getting transaction for [com.tx.transaction1.txapply.InternalCallV2Test$InternalService.internal]
     * 2022-08-18 13:32:21.529  INFO 480188 --- [    Test worker] c.t.t.txapply.InternalCallV2Test         : Call internal
     * 2022-08-18 13:32:21.529  INFO 480188 --- [    Test worker] c.t.t.txapply.InternalCallV2Test         : TX Active : true
     * 2022-08-18 13:32:21.529 TRACE 480188 --- [    Test worker] o.s.t.i.TransactionInterceptor           : Completing transaction for [com.tx.transaction1.txapply.InternalCallV2Test$InternalService.internal]
     */
    @Test
    void externalCallV2() {
        callService.external();
    }

    @Slf4j
    @RequiredArgsConstructor
    static class CallService {

        /**
         * Bean으로 등록하여 새롭게 호출한다.
         */
        private final InternalService internalService;

        public void external() {
            log.info("Call External");
            printTxInfo();
            // 여기다
            internalService.internal();
        }

        private void printTxInfo() {
            boolean isTxActive = TransactionSynchronizationManager.isActualTransactionActive();
            log.info("TX Active : {}", isTxActive);
        }
    }

    static class InternalService {

        /**
         * 외부 서비스로 추출한 다음 @Transactional 로 호출하면 AOP 가 적용된다.
         */
        @Transactional
        public void internal() {
            log.info("Call internal");
            printTxInfo();
        }

        private void printTxInfo() {
            boolean isTxActive = TransactionSynchronizationManager.isActualTransactionActive();
            log.info("TX Active : {}", isTxActive);
        }
    }
}
