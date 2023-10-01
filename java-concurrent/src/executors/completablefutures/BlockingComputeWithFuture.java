package executors.completablefutures;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class BlockingComputeWithFuture {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        List<Future<Integer>> futureList = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            Future<Integer> future = executorService.submit(() -> {
                return new BlockingComputeTask().calculatePrice(null);
            });
            futureList.add(future);
        }

        for (Future<Integer> future : futureList) {
            try {
                System.out.printf("calculate value: %d\n", future.get());
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        }
        executorService.shutdown();
    }
}
