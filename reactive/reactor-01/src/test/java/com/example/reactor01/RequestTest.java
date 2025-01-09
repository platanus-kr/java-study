package com.example.reactor01;

import com.example.reactor01._06_request.RequestUser;
import org.junit.jupiter.api.Test;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

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
    
    @Test
    void subscribeTest() {
        Flux.range(1, 100)
                .log()
                .doOnNext(System.out::println)
                .subscribe(new Subscriber<Integer>() { // 백프레셔 정책을 포함해서 스트림 처리를 위한 코드가 여기 구현되야함. (중요)
                    
                    private Subscription subscription;
                    private int count;
                    
                    @Override
                    public void onSubscribe(Subscription s) {
                        this.subscription = s;
                        this.subscription.request(10); // 이부분을 WebFlux 가 관리해준다.
                    }
    
                    @Override
                    public void onNext(Integer integer) {
                        count++;
                        if(count %10 ==0) {
                            this.subscription.request(10);
                        }
                    }
    
                    @Override
                    public void onError(Throwable t) {
        
                    }
    
                    @Override
                    public void onComplete() {
        
                    }
                });
    }

}

