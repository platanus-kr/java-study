package com.example.reactor01._04_transform;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.util.List;

public class FlatMap01 {

    // http://javatechnicalwealth.com/blog/reactive-flatmap


    // .map()       Sync
    // .flatMap()   Async
    // BlockHound - blocking 코드 찾기

    // .subscribeOn(), .publishOn() - Blocking API -> Threadpool 격리하는 코드
    // ex)
    // publishOn(Schedulers.boundedElastic())
    // .map(...)

    public static void main(String[] args) {
        FlatMap01 o = new FlatMap01();
        o.flatMap01();
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-");
        o.flatMap02();
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-");
        o.flatMap03();
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-");
        o.flatMap04();
    }

    /**
     * 이렇게 하면 아무런 장점이 없다.
     * map()은 blocking 방식이다.
     */
    public void flatMap01() {
        Flux.just("a", "b", "c", "d", "e", "f", "g", "h", "i")
                // window()로 자르면 Flux의 Flux가 된다.
                .window(3)
                .flatMap(l -> l.map(this::toUpperCase))
                .doOnNext(System.out::println)
                .blockLast();
    }

    /**
     * 3초를 대기하는 것은 똑같다.
     * 하지만 병렬로 실행된다.
     * 그러나 순서가 보장되지 않는다.
     */
    public void flatMap02() {
        Flux.just("a", "b", "c", "d", "e", "f", "g", "h", "i")
                .window(3)
                .flatMap(l -> l.map(this::toUpperCase).subscribeOn(Schedulers.parallel()))
                .doOnNext(System.out::println)
                .blockLast();
    }

    /**
     * 순차적으로 처리하지만 parallel의 의미가 없어진다.
     */
    public void flatMap03() {
        Flux.just("a", "b", "c", "d", "e", "f", "g", "h", "i")
                .window(3)
                .concatMap(l -> l.map(this::toUpperCase).subscribeOn(Schedulers.parallel()))
                .doOnNext(System.out::println)
                .blockLast();
    }

    /**
     * 결과를 기다렸다가 parallel 처리를 순차처리하여 가져온다.
     */
    public void flatMap04() {
        Flux.just("a", "b", "c", "d", "e", "f", "g", "h", "i")
                .window(3)
                .flatMapSequential(l -> l.map(this::toUpperCase).subscribeOn(Schedulers.parallel()))
                .doOnNext(System.out::println)
                .blockLast();
    }

    private List<String> toUpperCase(String s) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return List.of(s.toUpperCase(), Thread.currentThread().getName());

    }


}
