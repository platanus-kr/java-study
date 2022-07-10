package org.platanus.designpattern.decorator2;

public class TrafficDecorator extends DisplayDecorator {


    public TrafficDecorator(Display decoratorDisplay) {
        super(decoratorDisplay);
    }

    public void draw() {
        super.draw();
        drawTraffic();
    }

    public void drawTraffic() {
        System.out.println("\tShow traffic.");
    }
}
