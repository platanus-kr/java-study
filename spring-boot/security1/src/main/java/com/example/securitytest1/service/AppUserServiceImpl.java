package com.example.securitytest1.service;

import com.example.securitytest1.domain.AppUser;
import com.example.securitytest1.domain.Role;
import com.example.securitytest1.repo.AppUserRepository;
import com.example.securitytest1.repo.RoleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class AppUserServiceImpl implements AppUserService, UserDetailsService {
    private final AppUserRepository appUserRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public AppUser saveUser(AppUser appUser) {
        log.info("새로운 유저 {}를 데이터베이스에 추가", appUser.getName());
        appUser.setPassword(passwordEncoder.encode((appUser.getPassword())));
        return appUserRepository.save(appUser);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("새로운 역할 {}을 데이터베이스에 추가", role.getName());
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        log.info("{} 역할을 {} 사용자에게 추가", roleName, username);
        AppUser appUser = appUserRepository.findByUsername(username);
        Role role = roleRepository.findByName(roleName);
        appUser.getRoles().add(role);
    }

    @Override
    public AppUser getUser(String username) {
        log.info("사용자 {}를 가져오기", username);
        return appUserRepository.findByUsername(username);
    }

    @Override
    public List<AppUser> getUsers() {
        log.info("모든 사용자 가지고 오기");
        return appUserRepository.findAll();
    }

    /**
     * UserDetailsService 구현<br />
     *
     * @param username the username identifying the user whose data is required.
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser user = appUserRepository.findByUsername(username);
        if (user == null) {
            log.error("사용자를 찾을 수 없음");
            throw new UsernameNotFoundException("사용자를 찾을 수 없음");
        } else {
            log.info("사용자 : {}", username);
        }
        Collection<SimpleGrantedAuthority> authorites = new ArrayList<>();
        user.getRoles().forEach(role -> {
            authorites.add(new SimpleGrantedAuthority(role.getName()));
        });
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorites);
    }
}
