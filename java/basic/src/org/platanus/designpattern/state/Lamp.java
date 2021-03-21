package org.platanus.designpattern.state;

public class Lamp {

    private static int ON = 1;  // 형광등이 켜진 상태
    private static int OFF = 0; // 형광등이 꺼진 상채
    private int state;          // 형광등의 현재 상채

    public Lamp() {
        state = OFF;
    }

    public void onButtonPush() {
        if (state == ON) {
            System.out.println("-- No affect --");
        }
        if (state == OFF) {
            System.out.println(" !! Lamp on !!");
            state = ON;
        }
    }

    public void offButtonPush() {
        if (state == OFF) {
            System.out.println("-- No affect --");
        }
        if (state == ON) {
            System.out.println(" !! Lamp off !!");
            state = OFF;
        }
    }
}
