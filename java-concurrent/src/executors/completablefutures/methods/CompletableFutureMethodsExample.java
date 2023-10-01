package executors.completablefutures.methods;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CompletableFutureMethodsExample {

    public static void main(String[] args) {
        Runnable mainTask = () -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (Exception e) {

            }
            System.out.println("Main Task : " + Thread.currentThread().getName());

        };

        Runnable subTask = () -> {
            System.out.println("Next Task : " + Thread.currentThread().getName());
        };


        ExecutorService executorService = Executors.newFixedThreadPool(2);

        CompletableFuture.runAsync(mainTask, executorService).thenRun(subTask);
        CompletableFuture.runAsync(mainTask, executorService).thenRun(subTask);
        CompletableFuture.runAsync(mainTask, executorService).thenRun(subTask);
        CompletableFuture.runAsync(mainTask, executorService).thenRun(subTask);

        executorService.shutdown();
    }
}
