package org.platanus.designpattern.factorymethodpattern3;


public interface ElevatorScheduler {

    public int selectElevator(ElevatorManager manager, int destination, Direction direction);

}
