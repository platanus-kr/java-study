package org.fundamental.io.FileWriter;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterTest {

    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("writer.txt");
        try (fw) {
            fw.write('강');
            char buf[] = {'H', 'E', 'L', 'L', 'O'};

            fw.write(buf);
            fw.write("안녕하세요");
            fw.write("65");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
