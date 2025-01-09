package org.fundamental.designpattern.abstractfactory;

public class DoorFactory {

    public static Door createDoor(VendorID vendorID) {
        Door door = null;
        switch (vendorID) {
            case OTIS:
                door = new OtisDoor();
                break;
            case HYUNDAI:
                door = new HyundaiDoor();
                break;
        }
        return door;
    }
}
