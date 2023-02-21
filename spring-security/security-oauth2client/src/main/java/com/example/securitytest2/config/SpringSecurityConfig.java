package com.example.securitytest2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import lombok.RequiredArgsConstructor;

@EnableWebSecurity
@RequiredArgsConstructor
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SpringSecurityConfig {

	//private final AuthenticationConfiguration authConfig;
	private final CustomOAuth2UserService customOAuth2MemberService;

//	private final CustomO
	//@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
		return authConfig.getAuthenticationManager();
	}

	@Bean
	public SecurityFilterChain configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/oauth_login", "/nice/test", "/", "/error", "/h2-console/**").permitAll()
				.anyRequest().authenticated()
				.and()
				.csrf()
				.ignoringAntMatchers("/h2-console/**")
				.and()
				.headers().frameOptions().sameOrigin();
		http.oauth2Login().defaultSuccessUrl("/", true)
				.and()
				.logout().logoutSuccessUrl("/");
		return http.build();
	}
}
