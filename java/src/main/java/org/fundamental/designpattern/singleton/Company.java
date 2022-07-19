package org.fundamental.designpattern.singleton;

public class Company {

    private static Company instance = new Company();

    private Company() {
    }


    public static Company getInstance() {
        if (instance == null) {
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
