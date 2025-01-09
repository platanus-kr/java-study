package org.concurrent.countdownlatch;

import org.designpattern.singleton.Worker;

import java.util.concurrent.CountDownLatch;
import java.util.stream.IntStream;

/**
 * https://imasoftwareengineer.tistory.com/100
 */
public class CustomExecutor {
    public static void main(String[] args) {
        CustomExecutor executor = new CustomExecutor();
        executor.runWorkers();
    }

    private void runWorkers() {
        // CountDownLatch와 실행하고자 하는 Worker의 수와 같아야됨 - 중요
        CountDownLatch countDownLatch = new CountDownLatch(10);
        IntStream.range(0,10)
                .mapToObj(i -> new CustomWorker(i, countDownLatch))
                .map(Thread::new)
                .forEach(Thread::start);

        try {
            countDownLatch.await(); // await만 하면 안되고 Worker 쪽에 countDown()도 추가해야됨
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("작업 완료");
    }
}
