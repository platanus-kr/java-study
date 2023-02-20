package com.example.securitytest2.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * 세션에 직렬화 하기 위한 DTO
 */
@Getter
@ToString
@AllArgsConstructor
public class SessionMemberDto implements Serializable {
	private String username;
	private String provider;
	private String profileImage;
	private MemberRole role;
}
