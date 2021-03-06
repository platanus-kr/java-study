package org.platanus.webappboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.MultipartAutoConfiguration;

@SpringBootApplication(exclude = {MultipartAutoConfiguration.class})
//@SpringBootApplication
public class WebappBoardApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebappBoardApplication.class, args);
    }

}
