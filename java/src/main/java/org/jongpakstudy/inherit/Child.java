package org.jongpakstudy.inherit;

public class Child extends Parent {

    // 어노테이션: 컴파일러에게 제공해주는 힌트
    @Override
    public void test(String message) {
        System.out.println(message);
    }

}
