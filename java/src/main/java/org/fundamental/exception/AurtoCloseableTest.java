package org.fundamental.exception;

public class AurtoCloseableTest {

    public static void main(String[] args) {
        AutoCloseableObject obj = new AutoCloseableObject();
        try (obj) {
            throw new Exception();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Exception.");
        }
    }

}
