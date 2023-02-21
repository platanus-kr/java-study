package org.designpattern.templatemethod3;

import org.designpattern.templatemethod3.CommonEnum.Direction;

public class BMotor extends Motor {

    public BMotor(Door door) {
        super(door);
    }

    protected void moveMotor(Direction direction) {
        System.out.println("Moving B motor " + direction);

    }
}