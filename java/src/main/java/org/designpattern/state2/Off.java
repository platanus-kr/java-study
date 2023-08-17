package org.designpattern.state2;

public class Off implements State {


    private static Off off = new Off();

    private Off() {
    }

    public static Off getInstance() {
//        if (off == null) {
//            off = new Off();
//        }
        return off;
    }

    @Override
    public void onButtonPushed(Lamp lamp) {
        System.out.println("!! Lamp on !!");
        lamp.setState(On.getInstance());
//        lamp.setState(new On(lamp));
    }

    @Override
    public void offButtonPushed(Lamp lamp) {
        System.out.println("-- no affect --");
    }
}
