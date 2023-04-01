package com.example.securitytest2.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.securitytest2.model.Member;
import com.example.securitytest2.controller.dto.MemberJoinRequestDto;
import com.example.securitytest2.model.MemberRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 일반 가입, 로그인을 위한 서비스
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class MemberService {
	private final MemberRepository memberRepository;
	private final PasswordEncoder passwordEncoder;
	
	public Member join(MemberJoinRequestDto memberJoinRequestDto) throws IllegalArgumentException {
		memberJoinRequestDto.setEncodedPassword(passwordEncoder.encode(memberJoinRequestDto.getPassword()));
		Member member = memberJoinRequestDto.toMember();
		memberRepository.findByUsername(member.getUsername())
				.ifPresent(v -> {
					throw new IllegalArgumentException(v.getUsername() + "는 이미 가입된 회원 입니다.");
				});
		memberRepository.save(member);
		return member;
	}
	
	
	public Member login(String username, String password) throws IllegalArgumentException {
		Member findMember = memberRepository.findByUsername(username)
				.orElseThrow(() -> new IllegalArgumentException("없는 회원 입니다."));
		if (!passwordEncoder.matches(password, findMember.getPassword())) {
			throw new IllegalArgumentException("(패스워드 일치안해)");
		}
		return findMember;
	}
}
