package com.helloworld.helloworld;

import com.helloworld.helloworld.repository.MemberRepository;
import com.helloworld.helloworld.repository.MemoryMemberRepository;
import com.helloworld.helloworld.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfiguration {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

}
