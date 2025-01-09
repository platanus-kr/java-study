package com.example.reactor01._06_request;

import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

/**
 * https://tech.io/playgrounds/929/reactive-programming-with-reactor-3/Request
 */
public class Request01 {

//    ReactiveRepository<RequestUser> repository = new ReactiveUserRepository();

    /**
     * Publisher - Subscriber 도식
     * https://github.com/platanus-kr/java-study/issues/1#issuecomment-1475272002
     *
     * request()는 backpressure 와 매우 밀접하다.
     * subscription backpressure 조절
     *
     * subscribe 구현은 테스트 코드에 있음.
     */

    public static void main(String[] args) throws InterruptedException {

        List<Integer> values = new ArrayList<>();
        for (int i = 0; i < 20000; i++) {
            values.add(i);
        }
//        Flux<Long> flux = Flux.interval(Duration.ofMillis(100)).take(4).log();
        Flux<Integer> flux = Flux.fromIterable(values).log();
        flux.doOnNext(v -> {
                    System.out.println(v);
                    System.out.println(Thread.currentThread().getName());
                })
                .subscribe(); // 데몬 스레드에서 도는것이 찍힌다.

        Thread.sleep(1000);


        Request01 o = new Request01();


//        Flux<User> fluxWithLog() {}
        o.findAll().log();

        //Flux<User> fluxWithDoOnPrintln() {}
        o.findAll().log()
                .doOnSubscribe(v -> System.out.println("Starring:"))
                .doOnNext(p -> System.out.println(p.getFirstname() + p.getLastname()))
                .doOnComplete(() -> System.out.println("The end!"));

        // 나머지 StepVerifier 테스트는 RequestTest 테스트코드에 있음.
    }

    // 21:35

    private Flux<RequestUser> findAll() {
        return null;
    }





}
