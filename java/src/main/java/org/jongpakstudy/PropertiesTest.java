package org.jongpakstudy;

import java.io.IOException;
import java.io.StringReader;
import java.util.Properties;

public class PropertiesTest {

    public static void main(String[] args) throws IOException {
        String conf = "" +
            "db.url=mysql://gggg.xxxx\n" +
            "db.userId=jongpak\n" +
            "db.userPW=test\n";

        Properties properties = new Properties();
        properties.load(new StringReader(conf));

        // 자바IO 추상화
        // Input/Output ---> 인간세계
        // InputStream / OutputStream ---> 바이트세계
        // Reader / Writer ---> 문자세계
        // BufferedReader --> 문자세계 (버퍼링 버전)

        System.out.println(properties);
        System.out.println(properties.get("db.url"));
    }

}
