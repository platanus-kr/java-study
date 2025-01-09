package executors.callables;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class CallableTask implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        Thread thread = Thread.currentThread();
        int result = getRandomInt();
        System.out.println("[" + thread.getName() + "] " + result + " RUNNING...");
        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    private int getRandomInt(){
        Random random = new Random();
        random.setSeed(System.currentTimeMillis());
        return random.nextInt(1_000);
    }
}
