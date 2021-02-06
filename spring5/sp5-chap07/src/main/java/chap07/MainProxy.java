package main.java.chap07;

public class MainProxy {

    public static void main(String[] args) {
        ExecutiveTimeCalculator timeToCalculator1 =
            new ExecutiveTimeCalculator(new ImplementCalculator());
        System.out.println(timeToCalculator1.factorial(20));

        ExecutiveTimeCalculator timeToCalculator2 =
            new ExecutiveTimeCalculator(new ImplementCalculator());
        System.out.println(timeToCalculator2.factorial(3));
    }

}
