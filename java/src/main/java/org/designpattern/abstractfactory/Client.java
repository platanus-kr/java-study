package org.designpattern.abstractfactory;

public class Client {

    public static void main(String[] args) {
        Door otisDoor = DoorFactory.createDoor(VendorID.OTIS);
        Motor otisMotor = MotorFactory.createMotor(VendorID.OTIS);
        otisMotor.setDoor(otisDoor);

        otisDoor.open();
        otisMotor.move(Direction.UP);
    }

}
