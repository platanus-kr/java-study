package org.platanus.designpattern.singleton;

public class CompanyMulti {
    private static Company instance = null;

    private CompanyMulti() {
    }


    public static Company getInstance() {
        if (instance == null) {
            instance = new CompanyMulti();
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
