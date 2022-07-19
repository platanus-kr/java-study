package org.fundamental.designpattern.strategy2;

public class SingleStrategy implements PickupStrategy {
    @Override
    public void pickupSelect() {
        System.out.println("이 기타는 3싱글 픽업을 갖고 있어요");
    }
}
