package org.fundamental.designpattern.abstractfactory;

public class HyundaiMotor extends Motor {

    public HyundaiMotor(Door door) {
        super(door);
    }

    @Override
    protected void moveMotor(Direction direction) {
        System.out.println("Moving HyundaiMotor " + direction);
    }
}



