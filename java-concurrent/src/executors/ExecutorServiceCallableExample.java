package executors;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceCallableExample {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        List<Integer> futureList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Future<Integer> submit = executorService.submit(new ExecutorServiceCallableTaskExample());

            try {
                futureList.add(submit.get());
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        }
        executorService.shutdown();

        System.out.println(futureList.size());
    }
}
