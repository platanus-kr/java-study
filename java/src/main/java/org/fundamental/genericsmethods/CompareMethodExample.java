package org.fundamental.genericsmethods;

public class CompareMethodExample {
    public static void main(String[] args) {
        Pair<Integer, String> p1 = new Pair<Integer, String>(1, "플라");
        Pair<Integer, String> p2 = new Pair<Integer, String>(1, "플라");
        boolean result1 = Util.<Integer, String>compare(p1, p2); // 타입 명시
        if (result1) {
            System.out.println("논리적으로 동등하다!");
        } else {
            System.out.println("논리적으로 동동하지 않다!");
        }

        Pair<String, String> p3 = new Pair("platanus1", "플라");
        Pair<String, String> p4 = new Pair("platanus2", "플라");
        boolean result2 = Util.compare(p3, p4); // 타입 추정
        if (result2) {
            System.out.println("논리적으로 동등하다!");
        } else {
            System.out.println("논리적으로 동동하지 않다!");
        }
    }
}
