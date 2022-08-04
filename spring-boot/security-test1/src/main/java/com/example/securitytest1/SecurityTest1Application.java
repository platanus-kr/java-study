package com.example.securitytest1;

import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.securitytest1.domain.Role;
import com.example.securitytest1.domain.User;
import com.example.securitytest1.service.UserService;

@SpringBootApplication
public class SecurityTest1Application {

    public static void main(String[] args) {
        SpringApplication.run(SecurityTest1Application.class, args);
    }

    CommandLineRunner run(UserService userService) {
        return args -> {
            userService.saveRole(new Role(null, "ROLE_USER"));
            userService.saveRole(new Role(null, "ROLE_MANAGER"));
            userService.saveRole(new Role(null, "ROLE_ADMIN"));
            userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

            userService.saveUser(new User(null, "MINCHEOL KANG", "pla", "1234", new ArrayList<>()));
            userService.saveUser(new User(null, "JONGHUN PARK", "jongpak", "1234", new ArrayList<>()));
            userService.saveUser(new User(null, "JINHYUK LEE", "jin-lee", "1234", new ArrayList<>()));
            userService.saveUser(new User(null, "JAEYOUNG SONG", "kkamac", "1234", new ArrayList<>()));

            userService.addRoleToUser("pla", "ROLE_USER");
            userService.addRoleToUser("pla", "ROLE_MANAGER");
            userService.addRoleToUser("pla", "ROLE_ADMIN");
            userService.addRoleToUser("pla", "ROLE_SUPER_ADMIN");
            userService.addRoleToUser("jongpak", "ROLE_USER");
            userService.addRoleToUser("jongpak", "ROLE_MANAGER");
            userService.addRoleToUser("jin-lee", "ROLE_USER");
            userService.addRoleToUser("kkamac", "ROLE_USER");

        };
    }

}
