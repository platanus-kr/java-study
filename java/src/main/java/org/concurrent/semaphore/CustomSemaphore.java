package org.concurrent.semaphore;

import java.util.concurrent.Semaphore;

public class CustomSemaphore {

    private final Semaphore semaphore;
    private final int maxThread;

    public CustomSemaphore(int maxThread) {
        this.maxThread = maxThread;
        this.semaphore = new Semaphore(maxThread);
    }

    public void run() {
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " : " +
                (semaphore.availablePermits()) + " 남은 세마포어");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        semaphore.release();

    }
}
