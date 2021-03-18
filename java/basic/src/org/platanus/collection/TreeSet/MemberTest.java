package org.platanus.collection.TreeSet;

import org.platanus.collection.dao.MemberComparable;

public class MemberTest {
    public static void main(String[] args) {
        MemberServiceComparable memberServiceComparable = new MemberServiceComparable();

        MemberComparable member1 = new MemberComparable(500, "강민철");
        MemberComparable member2 = new MemberComparable(501, "김민철");
        MemberComparable member3 = new MemberComparable(502, "이민철");
        MemberComparable member3_1 = new MemberComparable(502, "아니요");
        MemberComparable member4 = new MemberComparable(503, "최민철");

        memberServiceComparable.addMember(member1);
        memberServiceComparable.addMember(member3);
        memberServiceComparable.addMember(member2);
        memberServiceComparable.addMember(member3_1);
        memberServiceComparable.addMember(member4);

        memberServiceComparable.showAllMember();

        System.out.println("-------------");


    }
}