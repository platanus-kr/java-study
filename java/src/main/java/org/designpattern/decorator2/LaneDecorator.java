package org.designpattern.decorator2;

public class LaneDecorator extends DisplayDecorator {

    public LaneDecorator(Display decoratorDisplay) {
        super(decoratorDisplay);
    }

    public void draw() {
        super.draw();
        drawLane();
    }

    private void drawLane() {
        System.out.println("\tShow the lane.");
    }


}
