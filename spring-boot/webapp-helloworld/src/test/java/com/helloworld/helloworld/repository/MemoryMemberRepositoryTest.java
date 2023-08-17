package com.helloworld.helloworld.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.helloworld.helloworld.domain.Member;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("Spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
//        System.out.println("result = " + (result == member));

        assertThat(result).isEqualTo(member);
        org.junit.jupiter.api.Assertions.assertEquals(member, result);

    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("SpringBoot");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("JPA");
        repository.save(member2);

        System.out.println(member2);

        Member result = repository.findByName("SpringBoot").get();
        System.out.println(result);

        assertThat(result).isEqualTo(member1);

    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("Spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("Spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }

}
