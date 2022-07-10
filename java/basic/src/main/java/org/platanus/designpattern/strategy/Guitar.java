package org.platanus.designpattern.strategy;

public abstract class Guitar {
    private String name;

    public Guitar(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void play();

    public abstract void pickupSelect();
}
