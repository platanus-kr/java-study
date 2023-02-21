package org.designpattern.singleton;

public class CompanyWorkerLaunchThreadTest {

    private static final int THREAD_NUM = 12;

    public static void main(String[] args) {
        WorkerMultiLine[] worker = new WorkerMultiLine[THREAD_NUM];
        for (int i = 0; i < THREAD_NUM; i++) {
            worker[i] = new WorkerMultiLine(String.valueOf(i + 1));
            worker[i].start();
        }
    }

}
