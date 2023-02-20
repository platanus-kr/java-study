package com.example.securitytest2.config;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Target;

import org.springframework.security.access.prepost.PreAuthorize;

@Target(ElementType.METHOD)
@Inherited
@PreAuthorize("hasRole(T(com.example.securitytest2.model.MemberRole).ROLE_USER.getKey())")
public @interface HasLoginMember {
}
