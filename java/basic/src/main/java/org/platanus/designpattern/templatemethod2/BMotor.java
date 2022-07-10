package org.platanus.designpattern.templatemethod2;

import org.platanus.designpattern.templatemethod.CommonEnum.Direction;
import org.platanus.designpattern.templatemethod.CommonEnum.DoorStatus;
import org.platanus.designpattern.templatemethod.CommonEnum.MotorStatus;
import org.platanus.designpattern.templatemethod.Door;

public class BMotor extends Motor {

    private Door door;
    private MotorStatus mortorStatus;

    public BMotor(Door door) {
        super(door);
    }

    private void moveBMotor(Direction direction) {
        System.out.println("Moving B motor " + direction);

    }

    public MotorStatus getMortorStatus() {
        return mortorStatus;
    }

    public void setMortorStatus(MotorStatus mortorStatus) {
        this.mortorStatus = mortorStatus;
    }

    public void move(Direction direction) {
        MotorStatus motorStatus = getMortorStatus();
        if (motorStatus == MotorStatus.MOVING) {
            return;
        }

        DoorStatus doorStatus = door.getDoorStatus();
        if (doorStatus == DoorStatus.OPENED) {
            door.close();
        }

        moveBMotor(direction);
        setMortorStatus(MotorStatus.MOVING);
    }
}