package org.fundamental.designpattern.singleton;

public class WorkerMultiLine extends Thread {

    public WorkerMultiLine(String name) {
        super(name);
    }

    public void run() {
        CompanyThread company = CompanyThread.getInstance();
        company.foodDistribute(
            "No." + Thread.currentThread().getName() +
                " ration food in " + company.toString()
        );
    }
}
