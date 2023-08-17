package com.example.reactor01._07_error;


import reactor.core.Exceptions;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * https://www.codingame.com/playgrounds/929/reactive-programming-with-reactor-3/Error
 */
public class Error01 {
//========================================================================================
	
	// TODO Return a Mono<User> containing User.SAUL when an error occurs in the input Mono,
	//  else do not change the input Mono.
	Mono<User> betterCallSaulForBogusMono(Mono<User> mono) {
		//return mono.onErrorResume(e -> Mono.just(User.SAUL));
		return mono.onErrorReturn(User.SAUL);
		
		/**
		 * 차이점
		 * onErrorResume() : 오류가 발생하면 대체된 '스트림'의 구독을 진행한다.
		 * 오류가 발생하면 오류에 따라 대체를 선택하는 기능을 사용하여 대체 게시자를 구독하십시오.
		 *
		 * onErrorReturn() : 오류가 발생하면 대체된 객체를 리턴함.
		 * 이 Mono에서 오류가 관찰되면 캡처된 폴백 값을 내보냅니다.
		 */
	}

//========================================================================================
	
	// TODO Return a Flux<User> containing User.SAUL and User.JESSE when an error occurs in the input Flux,
	//  else do not change the input Flux.
	Flux<User> betterCallSaulAndJesseForBogusFlux(Flux<User> flux) {
		return flux.onErrorResume(e -> Flux.just(User.SAUL, User.JESSE));
	}


//========================================================================================
	
	// TODO Implement a method that capitalizes each user of the incoming flux using the
	// #capitalizeUser method and emits an error containing a GetOutOfHereException error
	Flux<User> capitalizeMany(Flux<User> flux) {
		return flux.map(e -> {
			try {
				return capitalizeUser(e);
			} catch (GetOutOfHereException ex) {
				throw Exceptions.propagate(ex);
			}
		});
	}
	
	User capitalizeUser(User user) throws GetOutOfHereException {
		if (user.equals(User.SAUL)) {
			throw new GetOutOfHereException();
		}
		return new User(user.getUsername(), user.getFirstname(), user.getLastname());
	}
	
	protected final class GetOutOfHereException extends Exception {
		private static final long serialVersionUID = 0L;
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

