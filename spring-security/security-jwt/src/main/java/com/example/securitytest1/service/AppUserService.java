package com.example.securitytest1.service;

import java.util.List;

import com.example.securitytest1.domain.Role;
import com.example.securitytest1.domain.AppUser;

public interface AppUserService {
    AppUser saveUser(AppUser appUser);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    AppUser getUser(String username);
    List<AppUser> getUsers();

}
