package com.example.reactor01._02_fundermental;

import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.Arrays;

public class FluxComponent {

    // https://tech.io/playgrounds/929/reactive-programming-with-reactor-3/Flux

    public static void main(String[] args) {
        Flux<Object> empty1 = Flux.empty();

        Flux<String> just = Flux.just("foo", "bar");

        Flux<String> stringFlux = Flux.fromIterable(Arrays.asList("foo", "bar"));

        Flux<Object> error = Flux.error(new IllegalStateException());

        Flux<Long> take = Flux.interval(Duration.ofMillis(10)).take(10);


    }
}
