package org.fundamental.innerclass;

class Outer {

    int outNum = 100;
    static int sNum = 200;

    Runnable getRunnable(int i) {
        int num = 100;
        class MyRunnable implements Runnable {

            int localNum = 10;

            @Override
            public void run() {
                // num = 200; 지역변수는 상수로 바껴 불가능
                // i = 100; 매개변수 역시 상수화
                System.out.println("i: " + i);
                System.out.println("num: " + num);
                System.out.println("localNum: " + localNum);
                System.out.println("outNum: " + outNum);
                System.out.println("Outer.sNum: " + Outer.sNum);
            }
        }
        return new MyRunnable();
    }
}

public class LocalInnerTest {

    public static void main(String[] args) {
        Outer out = new Outer();
        Runnable runner = out.getRunnable(10);
        runner.run();
    }
}
