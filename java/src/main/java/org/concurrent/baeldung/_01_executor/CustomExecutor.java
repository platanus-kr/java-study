package org.concurrent.baeldung._01_executor;

import java.util.concurrent.Executor;

public class CustomExecutor {

    public static void main(String[] args) {
        for(int i = 0; i < 10; i++) {
            CustomInvoker invoker = new CustomInvoker();
            invoker.execute();
        }

    }

}
