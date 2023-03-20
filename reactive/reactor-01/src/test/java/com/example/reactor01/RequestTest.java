package com.example.reactor01;

import com.example.reactor01._06_request.RequestUser;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class RequestTest {
    @Test
    void test() {
        Flux<Integer> flux = Flux.just(0, 1, 2).take(2)
                .doOnNext(v -> {
                })
                .log();

        StepVerifier.create(flux, 1)
                .expectNext(0)
                .thenRequest(1)
                .expectNext(1)
                .verifyComplete();


    }

    @Test
    void test2() {
        //StepVerifier requestAllExpectFour(Flux<User> flux) {}

        Flux<RequestUser> flux = Flux.just(
                new RequestUser("asdf","asdf", "asdf"));

        StepVerifier.create(flux)
                .expectNextCount(4)
                .expectComplete();
    }

    @Test
    void test3() {
        // 	StepVerifier requestOneExpectSkylerThenRequestOneExpectJesse(Flux<User> flux) {}
        Flux<RequestUser> flux = Flux.just(
                new RequestUser("asdf","asdf", "asdf"));

        StepVerifier.create(flux, 1).expectNext(RequestUser.SKYLER)
                .thenRequest(1).expectNext(RequestUser.JESSE)
                .thenCancel();

    }

}

