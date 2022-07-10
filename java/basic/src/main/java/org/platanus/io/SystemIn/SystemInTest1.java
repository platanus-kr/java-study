package org.platanus.io.SystemIn;

import java.io.IOException;

public class SystemInTest1 {

    public static void main(String[] args) throws IOException {
        System.out.println("알파벳 하나와 엔터!");

        int i;
        try {
            i = System.in.read();
            System.out.println(i);
            System.out.println((char) i);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
