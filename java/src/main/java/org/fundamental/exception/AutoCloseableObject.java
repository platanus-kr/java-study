package org.fundamental.exception;

public class AutoCloseableObject implements AutoCloseable {

    @Override
    public void close() throws Exception {
        System.out.println("Resource closed.");
    }
}

