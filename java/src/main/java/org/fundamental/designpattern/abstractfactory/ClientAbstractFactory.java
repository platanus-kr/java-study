package org.fundamental.designpattern.abstractfactory;

public class ClientAbstractFactory {

    public static void main(String[] args) {

        ElevatorFactory factory = null;
        String vendorName = "HYUNDAI";
        if (vendorName.equalsIgnoreCase("OTIS")) {
            factory = new OtisElevatorFactory();
        }
        if (vendorName.equalsIgnoreCase("HYUNDAI")) {
            factory = new HyundaiElevatorFactory();
        }

        Door door = factory.createDoor();
        Motor motor = factory.createMotor();
        motor.setDoor(door);

        door.open();
        motor.move(Direction.UP);
    }

}
