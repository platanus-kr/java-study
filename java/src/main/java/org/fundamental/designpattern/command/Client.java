package org.fundamental.designpattern.command;

import org.fundamental.designpattern.command.Button.Mode;

public class Client {

    public static void main(String[] args) {
//        Lamp lamp = new Lamp();
//        Button lampButton = new Button(lamp);
//        lampButton.pressed();

//        Alarm alarm = new Alarm();
//        Button alarmButton = new Button(alarm);
//        alarmButton.pressed();

        Lamp lamp = new Lamp();
        Alarm alarm = new Alarm();
        Button button = new Button(lamp, alarm);

        button.setMode(Mode.LAMP);
        button.pressed();

        button.setMode(Mode.ALARM);
        button.pressed();
    }
}
