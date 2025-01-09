package com.example.securitytest2.controller.dto;


import com.example.securitytest2.model.Member;
import com.example.securitytest2.model.MemberRole;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 일반 회원가입을 위한 DTO
 */
@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MemberJoinRequestDto {
	
	private String username;
	
	private String password;
	private String name;
	private String email;
	
	public Member toMember() {
		return Member.builder()
				.username(this.username)
				.password(this.password)
				.name(this.name)
				.email(this.email)
				.provider("web")
				.role(MemberRole.ROLE_USER)
				.build();
	}
	
	public void setEncodedPassword(String password) {
		this.password = password;
	}
}
