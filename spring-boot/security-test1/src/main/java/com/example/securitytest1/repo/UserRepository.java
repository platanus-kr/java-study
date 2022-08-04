package com.example.securitytest1.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.securitytest1.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

}
