package com.example.securitytest2.model;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByProviderId(String id);
    
    Optional<Member> findByUsername(String username);
}
