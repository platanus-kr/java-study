package org.platanus.collection.arraylist;

import org.platanus.collection.dao.Member;

import java.util.ArrayList;

public class MemberService {
    private ArrayList<Member> list;

    public MemberService() {
        list = new ArrayList<Member>();
    }

    public void addMember(Member member) {
        list.add(member);
    }

    public boolean removeMember(int memberId) {
        for (int i = 0; i < list.size(); i++) {
            Member member = list.get(i);
            int id = member.getMemberId();
            if (id == memberId) {
                list.remove(i);
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
