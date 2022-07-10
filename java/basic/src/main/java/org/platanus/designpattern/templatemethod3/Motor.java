package org.platanus.designpattern.templatemethod3;

import org.platanus.designpattern.templatemethod3.CommonEnum.Direction;
import org.platanus.designpattern.templatemethod3.CommonEnum.DoorStatus;
import org.platanus.designpattern.templatemethod3.CommonEnum.MotorStatus;

public abstract class Motor {

    protected Door door;
    private MotorStatus motorStatus;

    public Motor(Door door) {
        this.door = door;
        motorStatus = MotorStatus.STOPPED;
    }

    public MotorStatus getMotorStatus() {
        return motorStatus;
    }

    protected void setMotorStatus(MotorStatus motorStatus) {
        this.motorStatus = motorStatus;
    }

    public void move(Direction direction) {
        MotorStatus motorStatus = getMotorStatus();
        if (motorStatus == MotorStatus.MOVING) {
            return;
        }

        DoorStatus doorStatus = door.getDoorStatus();
        if (doorStatus == DoorStatus.OPENED) {
            door.close();
        }

        moveMotor(direction); ///
        setMotorStatus(MotorStatus.MOVING);
    }

    protected void moveMotor(Direction direction) {

    }

}
