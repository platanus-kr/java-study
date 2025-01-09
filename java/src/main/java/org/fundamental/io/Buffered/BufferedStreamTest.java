package org.fundamental.io.Buffered;

import java.io.*;


public class BufferedStreamTest {

    public static void main(String[] args) throws FileNotFoundException {
        long mills = 0;
        BufferedInputStream bis =
            new BufferedInputStream(
                new FileInputStream("origin.zip"));
        BufferedOutputStream bos =
            new BufferedOutputStream(
                new FileOutputStream("copy.zip"));
        try (bis; bos) {
            mills = System.currentTimeMillis();
            int i;
            while ((i = bis.read()) != -1) {
                bos.write(i);
            }
            mills = System.currentTimeMillis() - mills;
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(mills + "");
    }
}


