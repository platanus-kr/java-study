package org.platanus.designpattern.singleton;

public class CompanyWorkerLaunchTest {

    public static void main(String[] args) {
        Worker[] workers = new Worker[7];
        for (int i = 0; i < workers.length; i++) {
            workers[i] = new Worker((i + 1) + " worker");
            workers[i].doLaunch();
        }
    }

}
