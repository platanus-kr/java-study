package org.fundamental.designpattern.abstractfactory;

public class OtisDoor extends Door {

    @Override
    protected void doClose() {
        System.out.println("Closing Otis Door.");
    }

    @Override
    protected void doOpen() {
        System.out.println("Opening Otis Door.");
    }
}
