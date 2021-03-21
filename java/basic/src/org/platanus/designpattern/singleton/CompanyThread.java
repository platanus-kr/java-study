package org.platanus.designpattern.singleton;

public class Company {

    private static Company instance = new Company();

    private Company() {
    }


    public static Company getInstance() {
        if (instance == null) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
            }
            instance = new Company();
        }
        return instance;
    }

    public void foodDistribute(String foodDist) {
        System.out.println(foodDist);
    }

    @Override
    public String toString() {
        return instance.getClass().getSimpleName() + "@" + instance.hashCode();
    }

}
