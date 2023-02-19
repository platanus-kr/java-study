package com.example.securitytest2.service;

import com.example.securitytest2.model.Member;
import com.example.securitytest2.model.MemberRepository;
import com.example.securitytest2.model.MemberRole;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Collections;

@Service
@RequiredArgsConstructor
public class CustomOAuth2MemberService implements OAuth2UserService {

    private final MemberRepository memberRepository;
    private final HttpSession session;


    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        DefaultOAuth2UserService service = new DefaultOAuth2UserService();
        OAuth2User oAuth2User = service.loadUser(userRequest);

        String registrationId = userRequest.getClientRegistration().getRegistrationId();
        String userNameAttributeName = userRequest.getClientRegistration().getProviderDetails().getUserInfoEndpoint().getUserNameAttributeName();
//
//        OAuthAttributes attributes = OAuthAttributes.of(registrationId,
//                userNameAttributeName,
//                oAuth2User.getAttributes());

        Member member = upsert(oAuth2User);

        session.setAttribute("oAuthToken", userRequest.getAccessToken().getTokenValue());
        return new DefaultOAuth2User(Collections.singleton(new SimpleGrantedAuthority(member.getRole().getKey())),
                oAuth2User.getAttributes(),
                "id");
    }

    private Member upsert(OAuth2User oAuth2User) {
        Member oAuthMember = Member.builder()
                .username(oAuth2User.getAttribute("login"))
                .name(oAuth2User.getAttribute("name"))
                .providerId(String.valueOf((Integer) (oAuth2User.getAttribute("id"))))
                .avatarUrl(oAuth2User.getAttribute("avatar_url"))
                .email(oAuth2User.getAttribute("email"))
                .role(MemberRole.ROLE_USER)
                .build();

        Member m = memberRepository.findByProviderId(oAuthMember.getProviderId())
                .map(e -> e.update(oAuthMember))
                .orElse(oAuthMember);

        return memberRepository.save(m);

    }
}
