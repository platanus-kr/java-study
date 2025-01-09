package org.platanus.designpattern.factorymethodpattern;

import java.util.ArrayList;
import java.util.List;
import org.platanus.designpattern.factorymethodpattern.CommonEnum.Direction;

public class ElevatorManager {

    private List<ElevatorController> controllers;
    private ThroughputScheduler scheduler;

    public ElevatorManager(int controllerCount) {
        controllers = new ArrayList<ElevatorController>(controllerCount);
        for (int i = 0; i < controllerCount; i++) {
            ElevatorController controller = new ElevatorController(i);
            controllers.add(controller);
        }
        scheduler = new ThroughputScheduler();
    }

    void requestElevator(int destination, Direction direction) {
        int selecedElevator = scheduler.selectElevator(this, destination, direction);

        controllers.get(selecedElevator).goToFloor(destination);
    }

}
