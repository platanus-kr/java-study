package org.fundamental.io.SystemIn;

import java.io.IOException;

public class SystemInTest2 {

    public static void main(String[] args) throws IOException {
        System.out.println("알파벳 여러개와 엔터!");

        int i;
        try {
            while ((i = System.in.read()) != -1) {
                System.out.print((char) i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
