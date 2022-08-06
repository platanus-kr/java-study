package com.example.securitytest1.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.securitytest1.domain.Role;
import com.example.securitytest1.domain.AppUser;
import com.example.securitytest1.repo.RoleRepository;
import com.example.securitytest1.repo.UserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Override
    public AppUser saveUser(AppUser appUser) {
        log.info("새로운 유저 {}를 데이터베이스에 추가", appUser.getName());
        return userRepository.save(appUser);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("새로운 역할 {}을 데이터베이스에 추가", role.getName());
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        log.info("{} 역할을 {} 사용자에게 추가", roleName, username);
        AppUser appUser = userRepository.findByUsername(username);
        Role role = roleRepository.findByName(roleName);
        appUser.getRoles().add(role);
    }

    @Override
    public AppUser getUser(String username) {
        log.info("사용자 {}를 가져오기", username);
        return userRepository.findByUsername(username);
    }

    @Override
    public List<AppUser> getUsers() {
        log.info("모든 사용자 가지고 오기");
        return userRepository.findAll();
    }
}
