package com.example.securitytest2.config;

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
public class CustomOAuth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {

    private final MemberRepository memberRepository;
    private final HttpSession session;


    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        DefaultOAuth2UserService service = new DefaultOAuth2UserService();
        OAuth2User oAuth2User = service.loadUser(userRequest);

        String registrationId = userRequest.getClientRegistration().getRegistrationId();
        String userNameAttributeName = userRequest.getClientRegistration().getProviderDetails().getUserInfoEndpoint().getUserNameAttributeName();
        CustomOAuthMember attributes = CustomOAuthMember.ofGitHub(registrationId, userNameAttributeName, oAuth2User.getAttributes());

        Member member = upsert(attributes);

        session.setAttribute("oAuthToken", userRequest.getAccessToken().getTokenValue());
        session.setAttribute("member", new SessionMember(member.getUsername(), member.getProvider(), member.getProfileImage(), member.getRole()));
        return new DefaultOAuth2User(Collections.singleton(new SimpleGrantedAuthority(member.getRole().getKey())), oAuth2User.getAttributes(), attributes.getNameAttributeKey());
    }

    private Member upsert(CustomOAuthMember m) {
        Member oAuthMember = Member.builder().username(m.getUsername()).name(m.getName()).providerId(m.getProviderId()).provider(m.getProvider()).profileImage(m.getProfileImage()).email(m.getEmail())
                .role(MemberRole.ROLE_USER)
                .build();

        Member findMember = memberRepository.findByProviderId(oAuthMember.getProviderId()).map(e -> e.update(oAuthMember)).orElse(oAuthMember);
        if (findMember == null) {
            Member defaultMember = m.toMember();
        }

        return memberRepository.save(findMember);
    }
}
