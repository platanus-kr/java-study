package org.designpattern.composite;

public class Computer {

    private CPU cpu;
    private VGA vga;
    private SSD ssd;

    public void addCPU(CPU cpu) {
        this.cpu = cpu;
    }

    public void addVGA(VGA vga) {
        this.vga = vga;
    }

    public void addSSD(SSD ssd) {
        this.ssd = ssd;
    }

    public int getPrice() {
        int cpuPrice = cpu.getPrice();
        int vgaPrice = vga.getPrice();
        int ssdPrice = ssd.getPrice();
        return cpuPrice + vgaPrice + ssdPrice;
    }

    public int getoPower() {
        int cpuPower = cpu.getPower();
        int vgaPower = vga.getPower();
        int ssdPower = ssd.getPower();
        return cpuPower + vgaPower + ssdPower;
    }


}
