package com.example.reactor01._04_flatmap;

public class FlatMap01 {
    // .map()       Sync
    // .flatMap()   Async
    // BlockHound - blocking 코드 찾기

    // .subscribeOn(), .publishOn() - Blocking API -> Threadpool 격리하는 코드
    // ex)
    // publishOn(Schedulers.boundedElastic())
    // .map(...)
}
