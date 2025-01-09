package org.fundamental.collection.compare;

import org.fundamental.collection.dao.Member;
import org.fundamental.collection.dao.MemberComparable;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamCompareTest {


    public static void main(String[] args) {
        List<Member> memberList = new ArrayList<>();

        Member member1 = new Member(2, "MINKANG");
        Member member2 = new Member(1, "SONGJAE");
        Member member3 = new Member(3, "JIN-LEE");

        memberList.add(member1);
        memberList.add(member2);
        memberList.add(member3);

        List<Member> sortedMemberList = memberList.stream()
                .sorted(new ComparatorImpl())
                .collect(Collectors.toList());

        System.out.println(sortedMemberList);
    }
}

