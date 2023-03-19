package com.example.reactor01._06_request;

import reactor.core.publisher.Flux;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Request01 {

    // https://tech.io/playgrounds/929/reactive-programming-with-reactor-3/Request

    /**
     * Publisher - Subscriber 도식
     * https://github.com/platanus-kr/java-study/issues/1#issuecomment-1475272002
     *
     * request()는 backpressure 와 매우 밀접하다.
     * subscription backpressure 조절
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
    }

    // 21:35






}
