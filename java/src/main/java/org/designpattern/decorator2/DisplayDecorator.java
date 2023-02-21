package org.designpattern.decorator2;

public class DisplayDecorator extends Display {

    private Display decoratorDisplay;

    public DisplayDecorator(Display decoratorDisplay) {
        this.decoratorDisplay = decoratorDisplay;
    }

    public void draw() {
        decoratorDisplay.draw();
    }

}
