package org.platanus.designpattern.templatemethod;

import org.platanus.designpattern.templatemethod.CommonEnum.Direction;
import org.platanus.designpattern.templatemethod.CommonEnum.DoorStatus;
import org.platanus.designpattern.templatemethod.CommonEnum.MotorStatus;

public class AMotor {

    private Door door;
    private MotorStatus mortorStatus;

    public AMotor(Door door) {
        this.door = door;
        mortorStatus = MotorStatus.STOPPED;
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
