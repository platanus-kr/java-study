package org.platanus;

import java.io.IOException;
import java.util.Scanner;

public class JavaApiTest {

    public static void main(String[] args) throws IOException {
//        long start = System.currentTimeMillis();
//        for (int i = 0; i < 1000000; i++) {
//            System.out.println(i);
//        }
//        System.out.println(System.currentTimeMillis() - start);
//
//        System.exit(1);

//        System.out.println(new String(System.in.readNBytes(5)));
        Scanner sc = new Scanner(System.in);

        while (true) {
            String line = sc.nextLine();
            if (line.equals("END")) {
                break;
            }
            System.out.println(line.toUpperCase());
        }
    }

}
