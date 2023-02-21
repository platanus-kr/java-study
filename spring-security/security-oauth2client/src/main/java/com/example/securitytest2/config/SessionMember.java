package com.example.securitytest2.config;

import java.io.Serializable;

import com.example.securitytest2.model.Member;
import com.example.securitytest2.model.MemberRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * 세션에 직렬화 하기 위한 DTO
 */
@Getter
@ToString
@AllArgsConstructor
public class SessionMember implements Serializable {
	private String username;
	private String provider;
	private String profileImage;
	private MemberRole role;

	public SessionMember(Member m){
		this.username = m.getUsername();
		this.provider = m.getProvider();
		this.profileImage = m.getProfileImage();
		this.role = m.getRole();
	}
}
