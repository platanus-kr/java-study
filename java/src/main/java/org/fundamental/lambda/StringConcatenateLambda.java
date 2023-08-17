package org.fundamental.lambda;

public class StringConcatenateLambda {

    public static void main(String[] args) {
        String str1 = "Hello";
        String str2 = "World";
        StringConcatgenate concatenate = (s, v) -> System.out.println(s + ", " + v);
        concatenate.makeString(str1, str2);
    }

}
