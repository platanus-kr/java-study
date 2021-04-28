package org.platanus.designpattern.composite2;

public class SSD extends ComputerDevice {

    private int price;
    private int power;

    public SSD(int power, int price) {
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