package org.platanus.innerclass;

public class OutClass {

    private int num = 10;
    private static int sNum = 20;

    private InClass inClass;

    public OutClass() {
        inClass = new InClass();
    }

    class InClass {

        int inNum = 100;
        // static int sInNum = 200; 내부 클래스에서 정적변수 선언 불가능

        void inTest() {
            System.out.println("OutClass num: " + num);
            System.out.println("OutClass sNum: " + sNum);
        }

        // static void sTest(){} 마찬가지로 내부클래스에서 정적메소드 선언 불가능

    }

    public void usingClass() {
        inClass.inTest();
    }
}

