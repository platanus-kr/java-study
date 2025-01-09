package org.fundamental.lambda;

interface PrintString {

    void showString(String str);
}

public class ParameterLambda {

    public static void main(String[] args) {
        PrintString lambdaString = s -> System.out.println(s);
        lambdaString.showString("Show prototype");
        showMyString(lambdaString);
    }

    public static void showMyString(PrintString p) {
        p.showString("Show parameter");
    }
}
