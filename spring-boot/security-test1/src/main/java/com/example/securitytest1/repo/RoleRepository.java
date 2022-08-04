package com.example.securitytest1.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.securitytest1.domain.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
