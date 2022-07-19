package org.fundamental.stream;

import java.util.ArrayList;
import java.util.List;

public class ArrayListStreamTest {

    public static void main(String[] args) {
        List<String> sList = new ArrayList<String>();
        sList.add("MINKANG");
        sList.add("JIN-LEE");
        sList.add("JONGPAK");

        sList.stream().forEach(s -> System.out.print(s + " "));
        System.out.println(" ");

        sList.stream().sorted().forEach(s -> System.out.println(s));
    }

}
