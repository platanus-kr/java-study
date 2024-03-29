package com.example.securitytest2.config.app;


import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

/**
 * formLogin 인증을 위한 구현체
 * MemberRepository 에서 조회한 비밀번호로 match() 한다.
 */
@Component
@RequiredArgsConstructor
public class CustomAuthenticationProvider implements AuthenticationProvider {
	private final CustomUserDetailsService customUserDetailsService;
	private final PasswordEncoder passwordEncoder;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();
		String password = (String) authentication.getCredentials();
		
		CustomUserDetailsUserAdaptor memberContext = (CustomUserDetailsUserAdaptor) customUserDetailsService.loadUserByUsername(username);
		String passwordInDb = memberContext.getMember().getPassword();
		
		if (!passwordEncoder.matches(password, passwordInDb)){
			throw new BadCredentialsException("비밀번호틀려");
		}
		return new UsernamePasswordAuthenticationToken(memberContext.getMember(), null, memberContext.getAuthorities());
	}
	
	@Override
	public boolean supports(Class<?> authentication) {
		return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
	}
}


