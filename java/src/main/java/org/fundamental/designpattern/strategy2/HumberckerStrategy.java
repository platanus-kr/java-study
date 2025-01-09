package org.fundamental.designpattern.strategy2;

public class HumberckerStrategy implements PickupStrategy {
    @Override
    public void pickupSelect() {
        System.out.println("이 기타는 2험버커 픽업을 갖고 있어요.");
    }
}
