package com.example.reactor01._05_merge;

import reactor.core.publisher.Flux;

import java.time.Duration;

/**
 * https://tech.io/playgrounds/929/reactive-programming-with-reactor-3/Merge
 */
public class Merge01 {

    public static void main(String[] args) {
        Flux<String> flux1 = Flux.interval(Duration.ofMillis(1000)).take(5).map(v -> v.toString());
        Flux<String> flux2 = Flux.just("A","B","C","D","E");

        // 두 개의 Flux 요소가 도착하는 즉시 병합.
        // 여기서 주의할 점은 flux1의 값이 지연되어 도착하므로
        // 결과 Flux에서 먼저 flux2의 값을 보기 시작한다는 것.
        flux1.mergeWith(flux2)
                .doOnNext(System.out::println)
                .blockLast();

        // 소스의 순서를 유지하려면 concat 연산자를 사용할 수 있다.
        // Concat은 flux2를 구독하기 전에 flux1이 완료될 때까지 대기하여
        // flux1의 모든 값이 방출되었는지 확인하여 소스에 해당하는 순서를 유지.
        flux1.concatWith(flux2)
                .doOnNext(System.out::println)
                .blockLast();
    }
}
