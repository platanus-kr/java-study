package org.fundamental.designpattern.abstractfactory;


public class MotorFactory {

    public static Motor createMotor(VendorID vendorID) {
        Motor motor = null;
        switch (vendorID) {
            case OTIS:
                motor = new OtisMotor(new OtisDoor());
                break;
            case HYUNDAI:
                motor = new HyundaiMotor(new HyundaiDoor());
                break;
        }
        return motor;
    }

}
