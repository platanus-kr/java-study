package org.platanus.io.Buffered;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopyTest {

    public static void main(String[] args) throws FileNotFoundException {
        long mills = 0;
        FileInputStream fis = new FileInputStream("origin.zip");
        FileOutputStream fos = new FileOutputStream("copy.zip");
        try (fis; fos) {
            mills = System.currentTimeMillis();
            int i;
            while ((i = fis.read()) != -1) {
                fos.write(i);
            }
            mills = System.currentTimeMillis() - mills;
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(mills + "");
    }
}
