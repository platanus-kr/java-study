package org.jongpakstudy.inherit;

public class Test {

    public static void main(String[] args) {
        Parent parent = new Parent();
        parent.test("Jongpak");

        // Parent
        // -- child
        Parent v1 = new Child();
        v1.test("Child");
//        child.test("test", 1234);
    }
}
