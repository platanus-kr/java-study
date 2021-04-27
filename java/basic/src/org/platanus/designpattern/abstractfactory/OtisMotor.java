package org.platanus.designpattern.abstractfactory;


public class OtisMotor extends Motor {

    public OtisMotor(Door door) {
        super(door);
    }

    @Override
    protected void moveMotor(Direction direction) {
        System.out.println("Moving OtisMotor " + direction);

    }
    
}