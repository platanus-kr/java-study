package com.helloworld.helloworld.service;

import com.helloworld.helloworld.domain.Member;
import com.helloworld.helloworld.repository.MemberRepository;
import com.helloworld.helloworld.repository.MemoryMemberRepository;
import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();

    public long join(Member member) {

        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
            .ifPresent(memberName -> {
                throw new IllegalStateException("Already exist member");
            });
    }

    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }

}
