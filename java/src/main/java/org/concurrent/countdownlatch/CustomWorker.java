package org.concurrent.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class CustomWorker implements Runnable{
    private CountDownLatch countDownLatch;
    private int index;

    public CustomWorker(final int index, final CountDownLatch countDownLatch) {
        this.index = index;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            System.out.println("스레드 시작" + index);
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("스레드 완료" + index);
            countDownLatch.countDown(); // 중요
        }

    }
}
