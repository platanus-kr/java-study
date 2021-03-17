package org.platanus.designpattern.strategy2;

public class GuitarPlayer {
    public static void main(String[] args) {
        Guitar strat = new Strat("미팬 스트랫");
        Guitar superStrat = new SuperStrat("ESP E-II");

        strat.setPickupStrategy(new SingleStrategy());
        superStrat.setPickupStrategy(new HumberckerStrategy());

        strat.setPlayStrategy(new PickingStrategy());
        superStrat.setPlayStrategy(new PalmmuteStrategy());

        System.out.println("이 기타의 이름은 " + strat.getName());
        strat.pickupSelect();
        strat.play();

        System.out.println("---------------");

        System.out.println("이 기타의 이름은 " + superStrat.getName());
        superStrat.pickupSelect();
        superStrat.play();
    }
}
