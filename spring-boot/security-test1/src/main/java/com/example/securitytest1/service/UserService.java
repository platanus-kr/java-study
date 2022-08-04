package com.example.securitytest1.service;

import java.util.List;

import com.example.securitytest1.domain.Role;
import com.example.securitytest1.domain.User;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    User getUser(String username);
    List<User> getUsers();

}
