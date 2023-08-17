package org.designpattern.command;

public class Button {

    private Lamp lamp;
    private Alarm alarm;
    private Mode mode;

    enum Mode {LAMP, ALARM}

    ;

//    public Button(Lamp lamp) {
//        this.lamp = lamp;
//    }
//
//    public void pressed() {
//        lamp.turnOn();
//    }

//    public Button(Alarm alarm) {
//        this.alarm = alarm;
//    }
//
//    public void pressed() {
//        alarm.start();
//    }

    public Button(Lamp lamp, Alarm alarm) {
        this.lamp = lamp;
        this.alarm = alarm;
    }

    public void setMode(Mode mode) {
        this.mode = mode;
    }

    public void pressed() {
        switch (mode) {
            case LAMP:
                lamp.turnOn();
                break;
            case ALARM:
                alarm.start();
                break;
        }
    }

}
