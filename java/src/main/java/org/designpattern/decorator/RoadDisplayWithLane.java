package org.designpattern.decorator;

public class RoadDisplayWithLane extends RoadDisplay {

    public void draw() {
        super.draw();
        drawLane();
    }

    private void drawLane() {
        System.out.println("Show the lane.");
    }


}
