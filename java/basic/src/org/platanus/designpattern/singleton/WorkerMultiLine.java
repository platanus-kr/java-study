package org.platanus.designpattern.singleton;

public class WorkerMultiLine extends Thread {
    public WorkerMultiLine(String name) {
        super(name);
    }

    public void doLaunch() {
        Company company = Company.getInstance();
        company.foodDistribute(
                "No." + Thread.currentThread().getName() +
                        " distributor is receiving food in " + company.toString()
        );
    }
}
