package org.designpattern.state2;

public class Lamp {

    private State state;

    public Lamp() {
        state = Off.getInstance();
    }

    public void setState(State state) {
        this.state = state;
    }

    public void onButtonPush() {
        state.onButtonPushed(this);
    }

    public void offButtonPush() {
        state.offButtonPushed(this);
    }

}
