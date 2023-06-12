package org.concurrent.baeldung._02_executorservice;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CustomExecutor {
    public static void main(String[] args) {
        final int N_THREADS = 10;
        ExecutorService executor = Executors.newFixedThreadPool(N_THREADS);

        // 첫번째 방법
        for (int i = 0; i < 10; i++) {
            CustomTask task = new CustomTask("");
            task.setThreadName(i + "번째");
            executor.submit(task);
        }
        // 두번째 방법
//        executor.submit(() -> {
//            new CustomTask();
//        });
    }
}
