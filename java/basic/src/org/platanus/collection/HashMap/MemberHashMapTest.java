package org.platanus.collection.HashMap;

import org.platanus.collection.dao.Member;

public class MemberHashMapTest {

    public static void main(String[] args) {
        MemberHashMap memberHashMap = new MemberHashMap();

        Member member1 = new Member(1001, "아이유");
        Member member2 = new Member(1002, "이지은");
        Member member3 = new Member(1003, "이지금");
        Member member4 = new Member(1004, "이지동");

        memberHashMap.addMember(member1);
        memberHashMap.addMember(member2);
        memberHashMap.addMember(member3);
        memberHashMap.addMember(member4);

        memberHashMap.showAllMember();

        memberHashMap.removeMember(1004);
        memberHashMap.showAllMember();
    }

}
