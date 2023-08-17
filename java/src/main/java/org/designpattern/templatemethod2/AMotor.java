package org.designpattern.templatemethod2;

import org.designpattern.templatemethod.CommonEnum.Direction;
import org.designpattern.templatemethod.CommonEnum.DoorStatus;
import org.designpattern.templatemethod.CommonEnum.MotorStatus;
import org.designpattern.templatemethod.Door;

public class AMotor extends Motor {

    private Door door;
    private MotorStatus mortorStatus;

    public AMotor(Door door) {
        super(door);
    }

    private void moveAMotor(Direction direction) {
        System.out.println("Moving A motor " + direction);
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

        moveAMotor(direction);
        setMortorStatus(MotorStatus.MOVING);
    }
}