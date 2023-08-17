package org.designpattern.factorymethodpattern2;

import org.designpattern.factorymethodpattern.CommonEnum.Direction;

public interface ElevatorScheduler {

    public int selectElevator(ElevatorManager manager, int destination, Direction direction);

}
