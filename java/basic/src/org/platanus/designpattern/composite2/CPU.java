package org.platanus.designpattern.composite2;

public class CPU extends ComputerDevice {

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
