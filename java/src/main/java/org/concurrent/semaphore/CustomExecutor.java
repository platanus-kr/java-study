package org.concurrent.semaphore;

/**
 * https://javaplant.tistory.com/30
 */
public class CustomExecutor {

    public static void main(String[] args) {
        final CustomSemaphore customSemaphore = new CustomSemaphore(5);

        for (int i = 0; i < 20; i++) {
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    customSemaphore.run();
                }
            });
            t.start();
        }
    }

}
