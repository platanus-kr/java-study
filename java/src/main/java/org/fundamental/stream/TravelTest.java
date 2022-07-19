package org.fundamental.stream;

import java.util.ArrayList;
import java.util.List;

public class TravelTest {

    public static void main(String[] args) {
        List<TravelCustomer> customerList = new ArrayList<>();
        customerList.add(new TravelCustomer("MINKANG", 30, 100));
        customerList.add(new TravelCustomer("JIN-LEE", 31, 200));
        customerList.add(new TravelCustomer("JONGPAK", 16, 300));

        System.out.println("== in-order customer list ==");
        customerList.stream()
            .map(c -> c.getName())
            .forEach(s -> System.out.println(s));

        int total =
            customerList.stream()
                .mapToInt(c -> c.getPrice())
                .sum();
        System.out.println("Total travel cost: " + total);

        System.out.println("== Customer list that age over 20");
        customerList.stream()
            .filter(c -> c.getAge() >= 20)
            .map(c -> c.getName())
            .sorted()
            .forEach(s -> System.out.println(s));

    }

}
