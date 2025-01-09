package org.platanus.designpattern.state2;

public class On implements State {

    private static On on = new On();

    private On() {
    }

    public static On getInstance() {
//        if (on == null) {
//            on = new On();
//        }
        return on;
    }

    @Override
    public void onButtonPushed(Lamp lamp) {
        System.out.println("-- no affect --");
    }

    @Override
    public void offButtonPushed(Lamp lamp) {
        System.out.println("!! Lamp off !!");
        lamp.setState(Off.getInstance());
//        lamp.setState(new Off(lamp));
    }
}
