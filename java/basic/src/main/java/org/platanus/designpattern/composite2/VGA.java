package org.platanus.designpattern.composite2;

public class VGA extends ComputerDevice {

    private int price;
    private int power;

    public VGA(int power, int price) {
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