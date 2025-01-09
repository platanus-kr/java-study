package org.designpattern.state;

public class Lamp {

    private static int ON = 1;  // 형광등이 켜진 상태
    private static int OFF = 0; // 형광등이 꺼진 상채
    private static int SLEEPING = 2; // 추가된 조건
    private int state;          // 형광등의 현재 상채

    public Lamp() {
        state = OFF;
    }

    public void onButtonPush() {
        if (state == ON) {
            System.out.println("-- No affect --");
        } else if (state == SLEEPING) {
            System.out.println("!! Lamp on !!");
            state = ON;
        } else {
            System.out.println(" !! Lamp on !!");
            state = ON;
        }
    }

    public void offButtonPush() {
        if (state == OFF) {
            System.out.println("-- No affect --");
        } else if (state == SLEEPING) {
            System.out.println("!! Lamp off !!");
            state = OFF;
        } else {
            System.out.println(" !! Lamp off !!");
            state = OFF;
        }
    }
}
