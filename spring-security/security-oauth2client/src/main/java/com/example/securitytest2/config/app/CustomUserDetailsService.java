package com.example.securitytest2.config.app;


import javax.persistence.EntityNotFoundException;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.securitytest2.model.Member;
import com.example.securitytest2.model.MemberRepository;

import lombok.RequiredArgsConstructor;

/**
 * CustomAuthenticationProvider 에서 사용할 UserDetailsService 구현체.
 * UserDetails 객체를 반환.
 */
@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
	private final MemberRepository memberRepository;
	
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Member m = memberRepository.findByUsername(username)
				.orElseThrow(EntityNotFoundException::new);
		return new CustomUserDetailsUserAdaptor(m);
	}
}
