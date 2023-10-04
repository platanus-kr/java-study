package org.fundamental.exception;

public class UncheckedExceptionExample {

    private int get(Integer i) {
        if (i <10) {
            throw new IllegalArgumentException("응애");
        }
        return i;
    }

    private void call() {
        get(100); // <<- 안난다.
    }


}
