package org.fundamental.lambda;


class Test {

    public static void main(String[] args) {
        String str1 = "Hello";
        String str2 = "World";
        StringConcatenateImpl concatenate = new StringConcatenateImpl();
        concatenate.makeString(str1, str2);
    }
}

public class StringConcatenateImpl implements StringConcatgenate {

    @Override
    public void makeString(String s1, String s2) {
        System.out.println(s1 + ", " + s2);
    }
}

