package org.fundamental.designpattern.factorymethodpattern2;

import org.fundamental.designpattern.factorymethodpattern.CommonEnum.Direction;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ElevatorManager {

    private List<ElevatorController> controllers;

    public ElevatorManager(int controllerCount) {
        controllers = new ArrayList<ElevatorController>(controllerCount);
        for (int i = 0; i < controllerCount; i++) {
            ElevatorController controller = new ElevatorController(i);
            controllers.add(controller);
        }
    }

    void requestElevator(int destination, Direction direction) {
        ElevatorScheduler scheduler;

        int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);

        if (hour < 12) {
            scheduler = new ResponseTimeScheduler();
        } else {
            scheduler = new ThroughputScheduler();
        }

        int selectedElevator = scheduler.selectElevator(this, destination, direction);
        controllers.get(selectedElevator).goToFloor(destination);
    }

}
