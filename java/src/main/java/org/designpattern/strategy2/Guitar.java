package org.designpattern.strategy2;

public abstract class Guitar {
    private String name;
    private PlayStrategy playStrategy;
    private PickupStrategy pickupStrategy;

    public Guitar(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    public void setPlayStrategy(PlayStrategy playStrategy) {
        this.playStrategy = playStrategy;
    }

    public void play() {
        playStrategy.play();
    }
    
    public void setPickupStrategy(PickupStrategy pickupStrategy) {
        this.pickupStrategy = pickupStrategy;
    }

    public void pickupSelect() {
        pickupStrategy.pickupSelect();
    }

}
