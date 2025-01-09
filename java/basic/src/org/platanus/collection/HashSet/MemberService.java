package org.platanus.collection.HashSet;

import org.platanus.collection.dao.Member;

import java.util.HashSet;
import java.util.Iterator;

public class MemberService {
    private HashSet<Member> hashSet;

    public MemberService() {
        hashSet = new HashSet<Member>();
    }

    public void addMember(Member member) {
        hashSet.add(member);
    }

    public boolean removeMember(int memberId) {
        Iterator<Member> iterator = hashSet.iterator();
        while (iterator.hasNext()) {
            Member member = iterator.next();
            int id = member.getMemberId();
            if (id == memberId) {
                hashSet.remove(member);
                return true;
            }
        }
        System.out.println("Invalid " + memberId);
        return false;
    }

    public void showAllMember() {
        for (Member member : hashSet) {
            System.out.println(member);
        }
        System.out.println("===End of Member===");
    }
}
