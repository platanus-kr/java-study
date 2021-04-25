package org.platanus.designpattern.templatemethod3;

import org.platanus.designpattern.templatemethod.CommonEnum.DoorStatus;
import org.platanus.designpattern.templatemethod.CommonEnum.MotorStatus;

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
        MotorStatus motorStatus = getMortorStatus();
        if (motorStatus == MotorStatus.MOVING) {
            return;
        }

        DoorStatus doorStatus = door.getDoorStatus();
        if (doorStatus == DoorStatus.OPENED) {
            door.close();
        }

        moveMotor(direction); ///
        setMortorStatus(MotorStatus.MOVING);
    }

    protected void moveAMotor(Direction direction) {

    }

}
