package org.fundamental.designpattern.strategy;

public class Strat extends Guitar {
    public Strat(String name) {
        super(name);
    }

    @Override
    public void play() {
        System.out.println("딩~ 디리리리딩~");
    }

    @Override
    public void pickupSelect() {
        System.out.println("3 싱글의 5단 픽업 셀랙터가 있어요.");
    }
}
