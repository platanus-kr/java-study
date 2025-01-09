package com.example.reactor01._02_fundermental;

import reactor.core.publisher.Mono;

public class MonoComponent {

    // https://tech.io/playgrounds/929/reactive-programming-with-reactor-3/Mono

    // 항목을 방출하지 않고 완료되는 Mono를 만듭니다.
    Mono<Object> empty = Mono.empty();

    // 기본적으로 무기한 실행되는 데이터, 오류 또는 완료 신호를 절대 보내지 않는 Mono를 반환합니다.
    Mono<Object> never = Mono.never();

    Mono<String> foo = Mono.just("foo");

    Mono<Object> error1 = Mono.error(new IllegalStateException());

}
