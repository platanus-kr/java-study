package com.helloworld.helloworld.service;

import static org.junit.jupiter.api.Assertions.assertThrows;

import com.helloworld.helloworld.domain.Member;
import com.helloworld.helloworld.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;


@SpringBootTest
@Transactional
class MemberServiceIntegrationTest {

    // 테스트 코드를 작성할때는 필드 주입방법으로 간단하게 진행한다.
    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;

//    @BeforeEach
//    public void beforeEach() {
//        memberRepository = new MemoryMemberRepository();
//        memberService = new MemberService(memberRepository);
//    }
//
//    @AfterEach
//    public void afterEach() {
//        memberRepository.clearStore();
//    }

    @Test
    void 회원가입() {
        // given
        Member member = new Member();
        member.setName("SpringBebe");

        // when
        Long saveId = memberService.join(member);

        // then
        Member findMember = memberService.findOne(saveId).get();
        Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());

    }

    @Test
    public void 중복_회원_예외() {
        // given
        Member member1 = new Member();
        member1.setName("Spring");

        Member member2 = new Member();
        member2.setName("Spring");

        // when
        memberService.join(member1);

        IllegalStateException e = assertThrows(
            IllegalStateException.class, () -> memberService.join(member2));
        Assertions.assertThat(e.getMessage()).isEqualTo("Already exist member");

        //then
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}