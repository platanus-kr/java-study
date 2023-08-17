package com.example.reactor01._09_others;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * https://www.codingame.com/playgrounds/929/reactive-programming-with-reactor-3/Other-utilities
 */
public class ReactorUtilMethods {


//========================================================================================

    // TODO Create a Flux of user from Flux of username, firstname and lastname.
    Flux<User> userFluxFromStringFlux(Flux<String> usernameFlux,
                                      Flux<String> firstnameFlux,
                                      Flux<String> lastnameFlux) {
        return Flux.zip(usernameFlux, firstnameFlux, lastnameFlux)
                .map(tuple -> new User(tuple.getT1(), tuple.getT2(), tuple.getT3()));
    }

//========================================================================================

    // TODO Return the mono which returns its value faster
    Mono<User> useFastestMono(Mono<User> mono1, Mono<User> mono2) {
        return Mono.first(mono1, mono2);
    }

//========================================================================================

    // TODO Return the flux which returns the first value faster
    Flux<User> useFastestFlux(Flux<User> flux1, Flux<User> flux2) {
        // Flux.firstEmitting() // firstEmitting deprecated since 3.4
        return Flux.firstWithSignal(flux1, flux2);
    }

//========================================================================================

    // TODO Convert the input Flux<User> to a Mono<Void>
    //  that represents the complete signal of the flux
    Mono<Void> fluxCompletion(Flux<User> flux) {
        return flux.then();
    }

//========================================================================================

    // TODO Return a valid Mono of user for null input and
    //  non null input user (hint: Reactive Streams do not accept null values)
    Mono<User> nullAwareUserToMono(User user) {
        return Mono.justOrEmpty(user);
    }

//========================================================================================

    // TODO Return the same mono passed as input parameter,
    //  expect that it will emit User.SKYLER when empty
    Mono<User> emptyToSkyler(Mono<User> mono) {
        return mono.defaultIfEmpty(User.SKYLER);
    }

//========================================================================================

    // TODO Convert the input Flux<User> to
    //  a Mono<List<User>> containing list of collected flux values
    Mono<List<User>> fluxCollection(Flux<User> flux) {

        return flux.collectList();
    }



}

class User {

    public static final User SKYLER = new User("swhite", "Skyler", "White");
    public static final User JESSE = new User("jpinkman", "Jesse", "Pinkman");
    public static final User WALTER = new User("wwhite", "Walter", "White");
    public static final User SAUL = new User("sgoodman", "Saul", "Goodman");

    private final String username;

    private final String firstname;

    private final String lastname;

    public User(String username, String firstname, String lastname) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        User user = (User) o;

        if (!username.equals(user.username)) {
            return false;
        }
        if (!firstname.equals(user.firstname)) {
            return false;
        }
        return lastname.equals(user.lastname);

    }

    @Override
    public int hashCode() {
        int result = username.hashCode();
        result = 31 * result + firstname.hashCode();
        result = 31 * result + lastname.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "username='" + username + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }
}


