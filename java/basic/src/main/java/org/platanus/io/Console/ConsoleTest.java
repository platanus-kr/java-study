package org.platanus.io.Console;

import java.io.Console;

public class ConsoleTest {

    public static void main(String[] args) {
        Console console = System.console();

        System.out.println("Name: ");
        String name = console.readLine();
        System.out.println("Job: ");
        String job = console.readLine();
        System.out.println("Password: ");
        char[] pass = console.readPassword();
        String strPass = new String(pass);

        System.out.println(name);
        System.out.println(job);
        System.out.println(strPass);
    }

}
