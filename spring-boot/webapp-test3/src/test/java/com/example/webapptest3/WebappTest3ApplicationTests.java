package com.example.webapptest3;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class WebappTest3ApplicationTests {

    static final String CURRENT_DIR = "platanus";

    @Test
    void contextLoads() {
    }

    /**
     * https://www.baeldung.com/java-current-directory
     */
    @Test
    void whenUsingJavaNioPaths_thenReturnCurrentDirectory() {
        String userDirectory = Paths.get("")
                .toAbsolutePath()
                .toString();
        System.out.println(userDirectory);
        assertTrue(userDirectory.endsWith(CURRENT_DIR));
    }

}
