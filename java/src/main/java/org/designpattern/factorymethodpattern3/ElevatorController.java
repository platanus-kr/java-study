package org.designpattern.factorymethodpattern3;

public class ElevatorController {

    private int id;
    private int currentFloor;

    public ElevatorController(int id) {
        this.id = id;
        currentFloor = 1;
    }

    public void goToFloor(int destination) {
        System.out.printf("Elevator [" + id + "] Floor: " + currentFloor);
        currentFloor = destination;
        System.out.println(" ==> " + currentFloor);
    }
}
