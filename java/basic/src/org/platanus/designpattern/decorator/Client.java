package org.platanus.designpattern.decorator;

public class Client {

    public static void main(String[] args) {
        RoadDisplay road = new RoadDisplay();
        road.draw(); // default road

        RoadDisplayWithLane roadWithLane = new RoadDisplayWithLane();
        roadWithLane.draw(); // show road and lane
    }

}
