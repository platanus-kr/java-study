package org.platanus.designpattern.templatemethod2;

import org.platanus.designpattern.templatemethod.CommonEnum.MotorStatus;
import org.platanus.designpattern.templatemethod.Door;

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

}
