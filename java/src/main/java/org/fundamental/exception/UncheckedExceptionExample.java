package org.fundamental.exception;

public class UncheckedExceptionExample {

    public static void main(String[] args) {
        UncheckedExceptionExample o = new UncheckedExceptionExample();
        o.call();
    }

    private int get(Integer i) {
        if (i < 10) {
            throw new IllegalArgumentException("응애");
        }
        return i;
    }

    private void call() {
        get(1); // <<- 런타임 전에는 안난다. 즉, checked가 아님!
    }


}
