package org.fundamental.lambda;

interface PrintString2 {

    void showString(String str);
}

public class ReturnLambda {

    public static void main(String[] args) {
        PrintString2 lambdaString = s -> System.out.println(s);
        PrintString2 retStr = returnString();
        retStr.showString("This");
    }

    public static PrintString2 returnString() {
        return s -> System.out.println(s + " is return type");
    }
}
