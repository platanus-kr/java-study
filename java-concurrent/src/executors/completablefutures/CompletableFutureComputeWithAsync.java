package executors.completablefutures;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class CompletableFutureComputeWithAsync {

    // Blocking 메서드를 Async 하게 처리하는 CompletableFuture 용법
    public static void main(String[] args) {
        CompletableFutureComputeTask asyncCompute = new CompletableFutureComputeTask();
        List<CompletableFuture<Integer>> result = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
//            CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
//                try {
//                    return asyncCompute.asyncCalculatePrice(null).get();
//                } catch (InterruptedException | ExecutionException e) {
//                    throw new RuntimeException(e);
//                }
//            });
            CompletableFuture<Integer> future = asyncCompute.asyncCalculatePrice(null);
            result.add(future);
        }

        List<Integer> join = CompletableFuture.allOf(result.toArray(new CompletableFuture[0]))
                .thenApply(Void -> result.stream()
                        .map(CompletableFuture::join)
                        .collect(Collectors.toList()))
                .join();

        for (Integer i : join) {
            System.out.println(i);
        }
    }
}
