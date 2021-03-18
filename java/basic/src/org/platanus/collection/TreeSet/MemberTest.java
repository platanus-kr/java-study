package org.platanus.collection.TreeSet;

import org.platanus.collection.dao.MemberComparable;

public class MemberTest {
    public static void main(String[] args) {
        MemberService memberService = new MemberService();

        MemberComparable member1 = new MemberComparable(500, "강민철");
        MemberComparable member2 = new MemberComparable(501, "김민철");
        MemberComparable member3 = new MemberComparable(502, "이민철");
        MemberComparable member3_1 = new MemberComparable(502, "아니요");
        MemberComparable member4 = new MemberComparable(503, "최민철");

        memberService.addMember(member1);
        memberService.addMember(member3);
        memberService.addMember(member2);
        memberService.addMember(member3_1);
        memberService.addMember(member4);

        memberService.showAllMember();

    }
}