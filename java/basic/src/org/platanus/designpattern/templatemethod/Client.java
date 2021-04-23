package org.platanus.designpattern.templatemethod;

public class Client {

    public static void main(String[] args) {
        Door door = new Door();
        AMotor aMotor = new AMotor(door);
        aMotor.move(Direction.UP);
    }

}
