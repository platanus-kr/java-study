package org.platanus.designpattern.composite;

public class CPU {

    private int price;
    private int power;

    public CPU(int power, int price) {
        this.power = power;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public int getPower() {
        return power;
    }

}
