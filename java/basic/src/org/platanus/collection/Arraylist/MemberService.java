package org.platanus.collection.Arraylist;

import org.platanus.collection.dao.Member;

import java.util.ArrayList;
import java.util.Iterator;

public class MemberService {
    private ArrayList<Member> list;

    public MemberService() {
        list = new ArrayList<Member>();
    }

    public void addMember(Member member) {
        list.add(member);
    }

    public boolean removeMember(int memberId) {
        Iterator<Member> iterator = list.iterator();
        while (iterator.hasNext()) {
            Member member = iterator.next();
            int id = member.getMemberId();
            if (id == memberId) {
                list.remove(member);
                return true;
            }
        }
        System.out.println("Invalid " + memberId);
        return false;
    }

    public void showAllMember() {
        for (Member member : list) {
            System.out.println(member);
        }
        System.out.println("===End of Member===");
    }
}
