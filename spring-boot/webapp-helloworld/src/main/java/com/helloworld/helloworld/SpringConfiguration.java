package com.helloworld.helloworld;

import com.helloworld.helloworld.repository.MemberRepository;
import com.helloworld.helloworld.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfiguration {

    private final MemberRepository memberRepository;

    public SpringConfiguration(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

//    private EntityManager em;
//
//    @Autowired
//    public SpringConfiguration(EntityManager em) {
//        this.em = em;
//    }

//    private DataSource dataSource;

//    @Autowired
//    public SpringConfiguration(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }

//    @Bean
//    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//        return new JdbcTemplateMemberRepository(dataSource);
//        return new JpaMemberRepository(em);
//    }

}
