package org.designpattern.strategy;

public class GuitarPlayer {
    public static void main(String[] args) {
        Guitar strat = new Strat("미팬 스트랫");
        Guitar superStrat = new SuperStrat("ESP E-II");

        System.out.println("이 기타의 이름은 " + strat.getName());
        strat.play();
        strat.pickupSelect();

        System.out.println("-------------");

        System.out.println("이 기타의 이름은 " + superStrat.getName());
        superStrat.play();
        superStrat.pickupSelect();
    }
}
