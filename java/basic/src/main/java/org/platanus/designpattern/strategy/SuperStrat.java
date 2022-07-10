package org.platanus.designpattern.strategy;

public class SuperStrat extends Guitar {
    public SuperStrat(String name) {
        super(name);
    }

    @Override
    public void play() {
        System.out.println("좌좡~ 좌우지좡지징~");
    }

    @Override
    public void pickupSelect() {
        System.out.println("2 험버커의 5단 픽업 셀렉터가 있어요.");
    }


}
