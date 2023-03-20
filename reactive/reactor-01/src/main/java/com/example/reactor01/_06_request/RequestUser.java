package com.example.reactor01._06_request;

public class RequestUser {


    public static final RequestUser SKYLER = new RequestUser("swhite", "Skyler", "White");
    public static final RequestUser JESSE = new RequestUser("jpinkman", "Jesse", "Pinkman");
    public static final RequestUser WALTER = new RequestUser("wwhite", "Walter", "White");
    public static final RequestUser SAUL = new RequestUser("sgoodman", "Saul", "Goodman");

    private final String username;

    private final String firstname;

    private final String lastname;

    public RequestUser(String username, String firstname, String lastname) {
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

        RequestUser user = (RequestUser) o;

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
