package org.fundamental.designpattern.abstractfactory;

public class HyundaiElevatorFactory extends ElevatorFactory {

    @Override
    public Motor createMotor() {
        return new HyundaiMotor(createDoor());
    }

    @Override
    public Door createDoor() {
        return new HyundaiDoor();
    }
}
