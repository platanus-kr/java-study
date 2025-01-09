package executors.callables;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableWithFutureCompute {
    public static void main(String[] args) {

        // ThreadPool 생성
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        // 객체 생성 후 ThreadPool 등록
        List<Future<Integer>> futureList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Future<Integer> submit = executorService.submit(new CallableTask());

            futureList.add(submit);
        }

        // Future 확인
        Long sumValue = 0L;
        for (Future<Integer> future : futureList) {
            try {
                sumValue += future.get();
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        }

        executorService.shutdown();

        System.out.println("작업 사이즈 : " + futureList.size());
        System.out.println("최종 합 : " + sumValue);
    }
}
