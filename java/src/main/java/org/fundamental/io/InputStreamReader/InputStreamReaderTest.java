package org.fundamental.io.InputStreamReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputStreamReaderTest {

    public static void main(String[] args) throws FileNotFoundException {
        InputStreamReader isr = new InputStreamReader(new FileInputStream("reader.txt"));
        try (isr) {
            int i;
            while ((i = isr.read()) != -1) {
                System.out.print((char) i);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
