package org.fundamental.exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class StreamExceptionHandling {

    public static void main(String[] args) {
        try {
            FileInputStream fileInputStream = new FileInputStream("context.txt");
            
        } catch (FileNotFoundException e) {
//            e.printStackTrace();
            System.out.println(e);
        }
        System.out.println("Execution.");
    }

}
