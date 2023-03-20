package com.example.reactor01;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.time.Duration;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StepVerifierTest {

    // https://tech.io/playgrounds/929/reactive-programming-with-reactor-3/StepVerifier

    @Test
    void test(){
        Flux<String> flux = Flux.just("foo", "bar");

        StepVerifier.create(flux)
                .expectNext("foo")
                .expectNext("bar")
                .verifyComplete();

        StepVerifier.create(flux)
                .expectNext("foo")
                .expectNext("bar")
                .verifyError(RuntimeException.class);
    }

    @Test
    void assertionTest(){

        Flux<User> users = Flux.just(new User("swhite"), new User("jpinkman"));
        StepVerifier.create(users)
                .assertNext(u -> assertThat(u.getUsername()).isEqualTo("swhite"))
                .assertNext(u -> assertThat(u.getUsername()).isEqualTo("jpinkman"))
                .verifyComplete();
    }

    public static class User {
        public String getUsername() {
            return username;
        }

        public User(String username) {
            this.username = username;
        }

        private String username;
    }

    @Test
    void emitDelay(){

        Flux<Long> take = Flux.interval(Duration.ofMillis(100)).take(10);
        StepVerifier.create(take)
                .expectNextCount(10)
                .verifyComplete();
    }

    @Test
    void emitDelayComplex() {
        // 안에 있는 스케줄러를 가상의 타이머로 교체하고 시간을 빨리 감는다.
        // ?? 왜 이거 없음? TODO 채우셈

    }
}
