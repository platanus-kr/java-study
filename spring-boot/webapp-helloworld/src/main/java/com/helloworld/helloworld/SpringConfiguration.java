package com.helloworld.helloworld;

import com.helloworld.helloworld.repository.JpaMemberRepository;
import com.helloworld.helloworld.repository.MemberRepository;
import com.helloworld.helloworld.service.MemberService;
import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfiguration {

    private EntityManager em;

    @Autowired
    public SpringConfiguration(EntityManager em) {
        this.em = em;
    }

//    private DataSource dataSource;

//    @Autowired
//    public SpringConfiguration(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//        return new JdbcTemplateMemberRepository(dataSource);
        return new JpaMemberRepository(em);
    }

}
