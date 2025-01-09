package org.platanus.collection.TreeSet;

import org.platanus.collection.dao.MemberComparable;

import java.util.Iterator;
import java.util.TreeSet;

public class MemberServiceComparable {
    private TreeSet<MemberComparable> treeSet;

    public MemberServiceComparable() {
        treeSet = new TreeSet<MemberComparable>();
    }

    public void addMember(MemberComparable member) {
        treeSet.add(member);
    }

    public boolean removeMember(int memberId) {
        Iterator<MemberComparable> iterator = treeSet.iterator();
        while (iterator.hasNext()) {
            MemberComparable member = iterator.next();
            int id = member.getMemberId();
            if (id == memberId) {
                treeSet.remove(member);
                return true;
            }
        }
        System.out.println("Invalid " + memberId);
        return false;
    }

    public void showAllMember() {
        for (MemberComparable member : treeSet) {
            System.out.println(member);
        }
        System.out.println("===End of Member===");
    }
}
