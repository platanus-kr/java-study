package org.platanus.designpattern.factorymethodpattern2;

import org.platanus.designpattern.factorymethodpattern.CommonEnum.Direction;

public interface ElevatorScheduler {

    public int selectElevator(ElevatorManager manager, int destination, Direction direction);

}
