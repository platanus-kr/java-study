package org.fundamental.designpattern.state;

public class LampTest {

    public static void main(String[] args) {
        Lamp lamp = new Lamp();
        lamp.onButtonPush();
        lamp.onButtonPush();
        lamp.offButtonPush();
        lamp.offButtonPush();
    }

}
