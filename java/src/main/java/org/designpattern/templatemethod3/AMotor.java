package org.designpattern.templatemethod3;

import org.designpattern.templatemethod3.CommonEnum.Direction;

public class AMotor extends Motor {

    public AMotor(Door door) {
        super(door);
    }

    protected void moveMotor(Direction direction) {
        System.out.println("Moving A motor " + direction);

    }
}