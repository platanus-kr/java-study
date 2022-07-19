package org.fundamental.classes;

public class StringBuilderTest {

    public static void main(String[] args) {
        String javaStr = new String("Java");
        System.out.println(System.identityHashCode(javaStr));

        StringBuilder buffer = new StringBuilder(javaStr);
        System.out.println(System.identityHashCode(buffer));

        buffer.append(" jammy");
        buffer.append(" it-da!");
        System.out.println(System.identityHashCode(buffer));

        javaStr = buffer.toString();
        System.out.println(javaStr);
        System.out.println(System.identityHashCode(javaStr));
    }

}
