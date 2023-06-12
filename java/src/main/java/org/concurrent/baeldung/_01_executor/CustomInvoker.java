package org.concurrent.baeldung._01_executor;

import java.util.concurrent.Executor;

public class CustomInvoker implements Executor {
    @Override
    public void execute(Runnable r) {
        r.run();
    }

    public void execute() {
        Executor executor = new CustomInvoker();
        executor.execute(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("test" + Thread.currentThread().getName());
        });
    }
}
