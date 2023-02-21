package org.designpattern.state2;

public interface State {

    public void onButtonPushed(Lamp lamp);

    public void offButtonPushed(Lamp lamp);

}
