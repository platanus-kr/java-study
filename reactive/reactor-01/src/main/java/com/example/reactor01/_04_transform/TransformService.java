package com.example.reactor01._04_transform;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * https://tech.io/playgrounds/929/reactive-programming-with-reactor-3/transform
 */

public class TransformService {

    Mono<User> capitalizeOne(Mono<User> mono) {
        return mono.map(u -> new User(u.getUsername().toUpperCase(),
                u.getFirstname().toUpperCase(),
                u.getLastname().toUpperCase()));
    }

    Flux<User> capitalizeMany(Flux<User> flux) {
        return flux.map(u -> new User(u.getUsername().toUpperCase(),
                u.getFirstname().toUpperCase(),
                u.getLastname().toUpperCase()));
    }

    Flux<User> asyncCapitalizeMany(Flux<User> flux) {
        /**
         * .flatMap()
         * 처리 자체에 지연이 있어 sync 처리보다 처리량을 늘릴려면.
         * 비동기 변환을 퍼블리셔로 감싸고 있다.
         * flatMap자체가 변경하는 행위를 감싼 퍼블리셔.
         * 비동기라 순서를 보장하지 않는다.
         * Mono<User>를 받아서
         */
        return flux.flatMap(this::asyncCapitalizeUser);
    }

    Mono<User> asyncCapitalizeUser(User u) {
        return Mono.just(new User(u.getUsername().toUpperCase(), u.getFirstname().toUpperCase(), u.getLastname().toUpperCase()));
    }

    public static void main(String[] args) {

    }
}
