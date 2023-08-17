package com.example.reactor01._10_reactive_transfrom;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ToReactive {
    //========================================================================================

    // TODO Create a Flux for reading all users from the blocking repository deferred until the flux is subscribed, and run it with a bounded elastic scheduler
    Flux<User> blockingRepositoryToFlux(BlockingRepository repository) {
        return Flux.defer(() -> Flux.fromIterable(repository.findAll()))
                .subscribeOn(Schedulers.boundedElastic());
    }

//========================================================================================

    // TODO Insert users contained in the Flux parameter in the blocking repository using a bounded elastic scheduler and return a Mono<Void> that signal the end of the operation
    Mono<Void> fluxToBlockingRepository(Flux<User> flux, BlockingRepository repository) {
        return flux.publishOn(Schedulers.boundedElastic())
                .doOnNext(repository::save)
                .then();
    }

    public static void main(String[] args) throws InterruptedException {
        BlockingRepository repository = new BlockingRepository();
        Flux.defer(() -> Flux.fromIterable(repository.findAll()))
                .subscribeOn(Schedulers.boundedElastic())
                .doOnNext(System.out::println)
                .subscribe();

        Thread.sleep(10000);
    }

    public static class BlockingRepository {

        public List<User> findAll() {
            return List.of(new User("mckang","mc","kang"),
                    new User("pla","ta","nus"));
        }

        public void save(User user) {

        }
    }

    public static class User {

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


}



