package executors;

public class ExecutorServiceRunnableTaskExample implements Runnable {
    @Override
    public void run() {
        Thread thread = Thread.currentThread();
        System.out.println("[" + thread.getName() + "]" + " RUNNING...");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
