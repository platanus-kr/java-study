package org.designpattern.singleton;

public class CompanyThread {

    private static CompanyThread instance = null;
    //    private static CompanyThread instance = new CompanyThread();
    private int counter = 0;

    private CompanyThread() {
    }

    public synchronized static CompanyThread getInstance() {
        if (instance == null) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            instance = new CompanyThread();
        }
        return instance;
    }

    public void foodDistribute(String foodDist) {
        synchronized (this) {
            counter++;
            System.out.println(foodDist + ". total counter " + counter);
        }
//        System.out.println(foodDist);
    }

    @Override
    public String toString() {
        return instance.getClass().getSimpleName() + "@" + instance.hashCode();
    }

}
