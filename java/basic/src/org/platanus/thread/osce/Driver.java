package org.platanus.thread.osce;

public class Driver {

    public static void main(String[] args) {
        int i = 10;

        if (i < 0) {
            System.err.println(i + " must be >= 0.");
        } else {
            Sum sum = new Sum();
            Thread thread = new Thread(new Summation(i, sum));
            thread.start();
            try {
                thread.join();
                System.out.println("The sum of " + i + " is " + sum.getSum());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
