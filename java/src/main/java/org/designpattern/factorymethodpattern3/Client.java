package org.designpattern.factorymethodpattern3;


public class Client {

    public static void main(String[] args) {
        ElevatorManager emWResponseTimeScheduler =
            new ElevatorManager(2, SchedulingStrategyID.RESPONSE_TIME);
        emWResponseTimeScheduler.requestElevator(10, Direction.UP);
        emWResponseTimeScheduler.requestElevator(3, Direction.UP);
        emWResponseTimeScheduler.requestElevator(1, Direction.UP);
        emWResponseTimeScheduler.requestElevator(5, Direction.DOWN);

        ElevatorManager emWTPScheduler =
            new ElevatorManager(2, SchedulingStrategyID.THROUGHPUT);
        emWTPScheduler.requestElevator(10, Direction.UP);

        ElevatorManager emWDynamicScheduler =
            new ElevatorManager(2, SchedulingStrategyID.DYNAMIC);
        emWDynamicScheduler.requestElevator(10, Direction.UP);
    }

}
