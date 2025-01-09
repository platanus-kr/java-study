package org.fundamental.designpattern.factorymethodpattern2;

import org.fundamental.designpattern.factorymethodpattern.CommonEnum.Direction;

public interface ElevatorScheduler {

    public int selectElevator(ElevatorManager manager, int destination, Direction direction);

}
