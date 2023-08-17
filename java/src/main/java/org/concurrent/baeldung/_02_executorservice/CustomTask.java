package org.concurrent.baeldung._02_executorservice;

public class CustomTask implements Runnable {

    public CustomTask (String threadName) {
        // 이런식으로는 셋업이 안됨. 일단 생성하고 나서 설정이네.
        Thread.currentThread().setName(threadName);
    }

    @Override
    public void run() {
        while(true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("test " + Thread.currentThread().getName());

        }
    }

    public void setThreadName(String threadName) {
        Thread.currentThread().setName(threadName);
    }
}
