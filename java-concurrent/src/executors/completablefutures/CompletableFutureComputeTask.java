package executors.completablefutures;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class CompletableFutureComputeTask {

    // Blocking 처리 테스트 메서드
    public static void main(String[] args) {
        BlockingComputeTask block = new BlockingComputeTask();

        for (int i = 0; i < 5; i++) {
            System.out.printf("calculate count: %s -> calculate value: %d\n",
                    (i + 1),
                    block.calculatePrice(null));
        }
    }

    public CompletableFuture<Integer> asyncCalculatePrice(Map<String, String> condition) {
//        CompletableFuture<Integer> future = new CompletableFuture<>();
//        int cal = calculatePrice(condition);
//        return CompletableFuture.completedFuture(cal);
        return CompletableFuture.supplyAsync(() -> calculatePrice(condition));
    }

    private int calculatePrice(Map<String, String> condition) {
        int price = getRandomInt();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (Exception e) {

        }
        return price;
    }

    private int getRandomInt() {
        Random random = new Random();
        random.setSeed(System.currentTimeMillis());
        return random.nextInt(1_000);
    }
}
