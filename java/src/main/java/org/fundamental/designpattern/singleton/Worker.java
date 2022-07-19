package org.fundamental.designpattern.singleton;

public class Worker {
    private String name;

    public Worker(String name) {
        this.name = name;
    }

    public void doLaunch() {
        Company company = Company.getInstance();
        company.foodDistribute(this.name + " is receiving food in " + company.toString());
    }
}
