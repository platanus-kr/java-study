package com.example.securitytest2.config;

import java.lang.annotation.*;

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
//@Inherited
//@PreAuthorize("hasRole(T(com.example.securitytest2.model.MemberRole).ROLE_USER.getKey())")
public @interface LoginMember {
}
