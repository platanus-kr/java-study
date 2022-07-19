package org.fundamental.io.FileOutputStream;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamTest {

    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("output.txt", true);
        try (fos) {
            fos.write(65);
            fos.write(66);
            fos.write(67);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("end");
    }

}
