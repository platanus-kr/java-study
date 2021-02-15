package com.helloworld.helloworld;

import com.helloworld.helloworld.repository.JdbcTemplateMemberRepository;
import com.helloworld.helloworld.repository.MemberRepository;
import com.helloworld.helloworld.service.MemberService;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfiguration {

    private DataSource dataSource;

    @Autowired
    public SpringConfiguration(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
        return new JdbcTemplateMemberRepository(dataSource);
    }

}
