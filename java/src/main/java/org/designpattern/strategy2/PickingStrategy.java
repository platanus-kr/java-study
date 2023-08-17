package org.designpattern.strategy2;

public class PickingStrategy implements PlayStrategy {
    @Override
    public void play() {
        System.out.println("딩딩디리링~");
    }
}
