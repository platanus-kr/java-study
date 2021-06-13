package com.example.payroll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements CommandLineRunner {

    private final EmployeeRepository repository;
    private final ManagerRepository managers;

    @Autowired
    public DatabaseLoader(EmployeeRepository repository, ManagerRepository managerRepository) {
        this.repository = repository;
        this.managers = managerRepository;
    }

    @Override
    public void run(String... strings) throws Exception {
        Manager pla = this.managers.save(new Manager("pla", "admin", "ROLE_MANAGER"));
        SecurityContextHolder.getContext().setAuthentication(
            new UsernamePasswordAuthenticationToken("pla", "1234",
                AuthorityUtils.createAuthorityList("ROLE_MANAGER")));
        this.repository.save(
            new Employee("Frodo", "Baggins", "ring bearer", pla)
        );
        this.repository.save(
            new Employee("Mincheol", "Kang", "hundred water", pla)
        );
        this.repository.save(
            new Employee("Sujin", "Noh", "wife", pla)
        );

        Manager tanus = this.managers.save(new Manager("tanus", "admin", "ROLE_MANAGER"));
        SecurityContextHolder.getContext().setAuthentication(
            new UsernamePasswordAuthenticationToken("tanus", "1234",
                AuthorityUtils.createAuthorityList("ROLE_MANAGER")));

        this.repository.save(
            new Employee("Jong", "Pak", "big teacher", tanus)
        );
        this.repository.save(
            new Employee("Jin", "Lee", "cadet", tanus)
        );

        SecurityContextHolder.clearContext();

    }
}
