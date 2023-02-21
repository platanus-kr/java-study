package org.designpattern.composite;

public class Client {

    public static void main(String[] args) {
        CPU amd5800x = new CPU(105, 60);
        VGA gtx3080 = new VGA(200, 200);
        SSD wd500 = new SSD(5, 15);

        Computer computer = new Computer();
        computer.addCPU(amd5800x);
        computer.addVGA(gtx3080);
        computer.addSSD(wd500);

        int computerPrice = computer.getPrice();
        int computerPower = computer.getoPower();
        System.out.println("Total price: " + computerPrice);
        System.out.println("Consume power: " + computerPower);
    }

}
