package org.fundamental.collection.HashSet;

import org.fundamental.collection.dao.Member;

public class MemberTest {
    public static void main(String[] args) {
        MemberService memberService = new MemberService();

        Member member1 = new Member(500, "강민철");
        Member member2 = new Member(501, "김민철");
        Member member3 = new Member(502, "이민철");
        Member member3_1 = new Member(502, "아니요");
        Member member4 = new Member(503, "최민철");

        memberService.addMember(member1);
        memberService.addMember(member2);
        memberService.addMember(member3);
        memberService.addMember(member3_1);
        memberService.addMember(member4);

        memberService.showAllMember();

    }
}