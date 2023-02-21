package org.designpattern.decorator2;

public class Client {

    public static void main(String[] args) {
        RoadDisplay road = new RoadDisplay();
        road.draw(); // default road

        LaneDecorator roadWithLane = new LaneDecorator(new RoadDisplay());
        roadWithLane.draw(); // show road and lane

        TrafficDecorator roadWithTraffic = new TrafficDecorator(new RoadDisplay());
        roadWithTraffic.draw();

        Display roadWithLaneAndTraffic =
            new TrafficDecorator(new LaneDecorator(new RoadDisplay())
            );
        roadWithLaneAndTraffic.draw();

        Display roadWithLaneAndTrafficAndCorssing =
            new CrossingDecorator(
                new TrafficDecorator(new LaneDecorator(new RoadDisplay()))
            );
        roadWithLaneAndTrafficAndCorssing.draw();
    }

}
