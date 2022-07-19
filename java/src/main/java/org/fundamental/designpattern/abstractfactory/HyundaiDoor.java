package org.fundamental.designpattern.abstractfactory;

public class HyundaiDoor extends Door {

    @Override
    protected void doClose() {
        System.out.println("Closing Hyundai Door.");
    }

    @Override
    protected void doOpen() {
        System.out.println("Opening Hyundai Door.");
    }
}
