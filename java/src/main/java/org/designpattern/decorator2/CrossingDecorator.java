package org.designpattern.decorator2;

public class CrossingDecorator extends DisplayDecorator {

    public CrossingDecorator(Display decoratorDisplay) {
        super(decoratorDisplay);
    }


    public void draw() {
        super.draw();
        drawCrossing();
    }

    private void drawCrossing() {
        System.out.println("\tShow the cross road.");
    }


}
