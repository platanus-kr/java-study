package com.example.securitytest2.controller.rest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.example.securitytest2.controller.dto.MemberJoinRequestDto;
import com.example.securitytest2.controller.dto.MemberLoginRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.securitytest2.config.dto.SessionMemberDto;
import com.example.securitytest2.model.Member;
import com.example.securitytest2.service.MemberService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 일반 가입을 위한 REST 컨트롤러
 */
@Slf4j
@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberLoginRestController {
	
	private final AuthenticationManager authenticationManager;
	private final MemberService memberService;
	
	@PostMapping("/join")
	public ResponseEntity<Void> join(@RequestBody(required = true) MemberJoinRequestDto mJoin, HttpServletRequest request) {
		Member joinMember;
		try {
			joinMember = memberService.join(mJoin);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException(e);
		}
		return ResponseEntity.ok().build();
	}
	
	
	/**
	 * REST API로 로그인하고 Spring Security Context에 세션 정보 추가. <br />
	 *
	 * @param requestLoginDto
	 * @param request
	 * @param session
	 * @return
	 */
	@PostMapping("/login")
	@ResponseBody
	public SessionMemberDto login(@RequestBody MemberLoginRequestDto requestLoginDto, HttpServletRequest request, HttpSession session) {
		
		//log.info(requestLoginDto.toString());
		Member loginMember;
		try {
			loginMember = memberService.login(requestLoginDto.getUsername(), requestLoginDto.getPassword());
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException(e);
		}
		
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(requestLoginDto.getUsername(), requestLoginDto.getPassword());
		Authentication authentication = authenticationManager.authenticate(token);
		SecurityContextHolder.getContext().setAuthentication(authentication); // 토큰으로 인증하는게 필요한듯.
		session.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY,
				SecurityContextHolder.getContext()); // 이건 왜 해주는지 한번 찾아보기
		
		session.setAttribute("member", new SessionMemberDto(loginMember.getId(), loginMember.getProvider(), loginMember.getUsername(), loginMember.getProfileImage(), loginMember.getHtmlUrl(), loginMember.getName(), loginMember.getEmail(), loginMember.getRole(), request.getSession().getId()));
		// 왜그런지 모르겠는데 빌더패턴으로 할당을 할 수 없네?
		return new SessionMemberDto(loginMember, session.getId());
	}
	
	@GetMapping("/logout")
	public ResponseEntity<Void> logout(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate();
		}
		return ResponseEntity.ok().build();
	}
	
}
