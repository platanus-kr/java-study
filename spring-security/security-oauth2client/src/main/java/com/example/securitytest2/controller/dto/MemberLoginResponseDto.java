package com.example.securitytest2.controller.dto;

import com.example.securitytest2.model.MemberRole;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 일반 로그인 응답을 위한 DTO
 */
@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MemberLoginResponseDto {
	private String username;
	private MemberRole role;
	private String token;
}
