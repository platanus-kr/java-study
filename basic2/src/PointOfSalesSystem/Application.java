package PointOfSalesSystem;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        POS pos = new POS();
        POS.launch(scanner);
    }

}
