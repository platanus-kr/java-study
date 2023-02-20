package com.example.securitytest1;

import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.securitytest1.domain.Role;
import com.example.securitytest1.domain.AppUser;
import com.example.securitytest1.service.AppUserService;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class SecurityTest1Application {

    public static void main(String[] args) {
        SpringApplication.run(SecurityTest1Application.class, args);
    }
    @Bean
    CommandLineRunner run(AppUserService appUserService) {
        return args -> {
            appUserService.saveRole(new Role(null, "ROLE_USER"));
            appUserService.saveRole(new Role(null, "ROLE_MANAGER"));
            appUserService.saveRole(new Role(null, "ROLE_ADMIN"));
            appUserService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

            appUserService.saveUser(new AppUser(null, "MINCHEOL KANG", "pla", "1234", new ArrayList<>()));
            appUserService.saveUser(new AppUser(null, "JONGHUN PARK", "jongpak", "1234", new ArrayList<>()));
            appUserService.saveUser(new AppUser(null, "JINHYEOK LEE", "jin-lee", "1234", new ArrayList<>()));
            appUserService.saveUser(new AppUser(null, "JAEYEONG SONG", "kkamac", "1234", new ArrayList<>()));

            appUserService.addRoleToUser("pla", "ROLE_USER");
            appUserService.addRoleToUser("pla", "ROLE_MANAGER");
            appUserService.addRoleToUser("pla", "ROLE_ADMIN");
            appUserService.addRoleToUser("pla", "ROLE_SUPER_ADMIN");
            appUserService.addRoleToUser("jongpak", "ROLE_USER");
            appUserService.addRoleToUser("jongpak", "ROLE_MANAGER");
            appUserService.addRoleToUser("jin-lee", "ROLE_USER");
            appUserService.addRoleToUser("kkamac", "ROLE_USER");

        };
    }
}
