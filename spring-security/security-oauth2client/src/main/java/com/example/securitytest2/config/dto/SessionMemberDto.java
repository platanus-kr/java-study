package com.example.securitytest2.config.dto;

import java.io.Serializable;

import com.example.securitytest2.model.Member;
import com.example.securitytest2.model.MemberRole;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 세션에 직렬화 하기 위한 DTO
 */
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SessionMemberDto implements Serializable {
	private Long id;
	private String provider;
	private String username;
	private String profileImage;
	private String htmlUrl;
	private String name;
	private String email;
	private MemberRole role;
	private String token;
	
	public SessionMemberDto(Member m, String token) {
		this.id = m.getId();
		this.provider = m.getProvider();
		this.username = m.getUsername();
		this.profileImage = m.getProfileImage();
		this.htmlUrl = m.getHtmlUrl();
		this.name = m.getName();
		this.role = m.getRole();
		this.token = token;
	}
}

