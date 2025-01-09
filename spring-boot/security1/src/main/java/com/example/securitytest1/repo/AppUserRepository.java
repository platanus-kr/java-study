package com.example.securitytest1.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.securitytest1.domain.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    AppUser findByUsername(String username);

}
