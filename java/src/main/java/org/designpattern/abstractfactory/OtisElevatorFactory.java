package org.designpattern.abstractfactory;

public class OtisElevatorFactory extends ElevatorFactory {

    @Override
    public Motor createMotor() {
        return new OtisMotor(createDoor());
    }

    @Override
    public Door createDoor() {
        return new OtisDoor();
    }
}
